package org.benignbala.grade.dpkg

import groovy.transform.CompileDynamic
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputFile
import org.gradle.util.CollectionUtils

/**
 * @author Balachandran Sivakumar
 */
class DpkgPackageExtension {
    static final String EXTENSTION_NAME = "dpkg"
    String executable = "dpkg"

    DpkgPackageExtension(Project p) {
        project = p
    }

    @Input
    @CompileDynamic
    String getPkgName() {
        this.pkgName
    }

    @Input
    @CompileDynamic
    void setPkgName(String pkg) {
        this.pkgName = pkg
    }

    @Input
    @CompileDynamic
    void  pkgName(String pkg) {
        this.pkgName = pkg
    }

    @InputFile
    @CompileDynamic
    File getSrcDir() {
        this.srcDir
    }

    @Input
    @CompileDynamic
    void setSrcDir(File dir) {
        this.srcDir = dir
    }

    @InputFile
    @CompileDynamic
    void srcDir(File f) {
        this.srcDir = f
    }

    @Input
    @CompileDynamic
    List<String> getArgs() {
        CollectionUtils.stringize(args)
    }

    @Input
    @CompileDynamic
    void setArgs(String arg) {
        this.args.add(arg)
    }

    @Input
    @CompileDynamic
    void args(Object... args) {
        this.args.addAll(args as List)
    }

    final Project project
    private String pkgName
    private File srcDir
    private List<String> args
}
