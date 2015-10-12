package org.benignbala.gradle.dpkg

import groovy.transform.CompileDynamic
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.Input

/**
 * @author Balachandran Sivakumar
 */
class DpkgPackageTask extends DefaultTask {
    DpkgPackageTask() {

    }

    @Input
    @CompileDynamic
    String getPkgName() {
	this.pkgName ?: project.extensions.getByName(DpkgPackageExtension.EXTENSION_NAME)?.pkgName
    }

    @Input
    @CompileDynamic
    Map getControlProp() {
	this.controlProp ?: project.extensions.getByName(DpkgPackageExtension.EXTENSION_NAME)?.controlProp
    }

    @Input
    @CompileDynamic
    File getSrcDir() {
	this.srcDir ?: project.extensions.getByName(DpkgPackageExtension.EXTENSION_NAME)?.srcDir
    }
    
    @TaskAction
    @CompileDynamic
    void exec() {
	srcDir = getSrcDir()
	PackageMaker.generateControlFile(project, srcDir)
        PackageMaker.makeDeb(project, DPKG_COMMAND, args, pkgName, srcDir)
    }

    static final String DPKG_COMMAND = "dpkg"
    private String pkgName
    private File srcDir
    private List<String> args = ["-b"]
    private Map controlProp = [:]
}
