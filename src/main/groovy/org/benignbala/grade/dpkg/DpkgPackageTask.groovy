package org.benignbala.grade.dpkg

import groovy.transform.CompileDynamic
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
/**
 * @author Balachandran Sivakumar
 */
class DpkgPackageTask extends DefaultTask {
    DpkgPackageTask() {

    }

    @TaskAction
    @CompileDynamic
    void exec() {
        PackageMaker.makeDeb(project, DPKG_COMMAND, args, pkgName, srcDir)
    }

    static final String DPKG_COMMAND = "dpkg"
    private String pkgName
    private File srcDir
    private List<String> args = ["-b"]
}
