package org.benignbala.grade.dpkg

import org.gradle.api.Project
import org.gradle.process.ExecResult

/**
 * @author Balachandran Sivakumar
 */
class PackageMaker {
    static ExecResult makeDeb(Project project, String cmd, List<String> params, String pkgName, File srcDir) {
        project.exec {
            executable = cmd
            params.add(srcDir.absolutePath)
            args = params
        }
    }

    static void generateControlFile(Project project, File srcDir) {
	def DEBIAN = new File(srcDir.absolutePath + "/DEBIAN")
	if (!DEBIAN.exists()) {
	    DEBIAN.mkdirs()
	}

	Map<String, String> control = project.extensions.findByName(DpkgPackageExtension.EXTENSION_NAME)?.controlProp ?: [:]
	new File(DEBIAN, 'control').withWriter { f ->
	    control.each {prop, val ->
		f.writeLine(prop + ": " + val)
	    }
	}
    }
}
