package org.benignbala.gradle.dpkg

import groovy.transform.CompileDynamic
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.util.CollectionUtils

/**
 * @author Balachandran Sivakumar
 */
class DpkgPackageExtension {
    static final String EXTENSION_NAME = "dpkg"
    String executable = "dpkg"

    DpkgPackageExtension(Project p) {
        project = p
    }

    @Input
    String getPkgName() {
        this.pkgName
    }

    void setPkgName(String pkg) {
        this.pkgName = pkg
    }

    void  pkgName(String pkg) {
        this.pkgName = pkg
    }

    @InputFile
    @CompileDynamic
    File getSrcDir() {
        this.srcDir
    }

    void setSrcDir(File dir) {
        this.srcDir = dir
    }

    @InputFile
    @CompileDynamic
    void srcDir(File f) {
        this.srcDir = f
    }

    @InputFile
    @CompileDynamic
    void srcDir(String f) {
      this.srcDir = new File(f)
    }

    @Input
    @CompileDynamic
    Map getControlProp() {
	this.controlProp
    }

    void setControlProp(Map props) {
	this.controlProp = props
    }

    void controlProp(Map props) {
	this.controlProp += props
    }
    
    final Project project
    private String pkgName
    private File srcDir
    private Map controlProp = [:]
}
