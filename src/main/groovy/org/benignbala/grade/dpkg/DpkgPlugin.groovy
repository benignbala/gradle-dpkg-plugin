package org.benignbala.grade.dpkg

import org.gradle.api.Plugin
import org.gradle.api.Project

/**
 * @author Balachandran Sivakumar
 */
class DpkgPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.extensions.create(DpkgPackageExtension.EXTENSTION_NAME, DpkgPackageExtension, project)
        project.tasks.create('dpkg', DpkgPackageTask).configure {
            description "Creates a .deb Debian package"
            group "Linux package management"
        }
    }

}
