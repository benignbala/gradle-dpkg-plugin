package org.benignbala.grade.dpkg

import org.gradle.api.Project
import org.gradle.process.ExecResult

/**
 * @author Balachandran Sivakumar
 */
class PackageMaker {
    static ExecResult makeDeb(Project project, String cmd, List<String> params, String pkgName, File srcDir) {
        project.exec {
            if (srcDir == null) {
                srcDir = project.extensions.findByName(DpkgPackageExtension.EXTENSTION_NAME)?.srcDir ?: ""
            }

            if (params == null) {
                params = project.extensions.findByName(DpkgPackageExtension.EXTENSTION_NAME)?.args ?: []
            }
            executable = cmd
            params.add(srcDir.absolutePath)
            args = params
        }
    }
}
