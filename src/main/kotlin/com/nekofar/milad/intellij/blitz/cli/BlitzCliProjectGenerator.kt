package com.nekofar.milad.intellij.blitz.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.blitz.BlitzBundle
import com.nekofar.milad.intellij.blitz.BlitzIcons
import javax.swing.Icon

class BlitzCliProjectGenerator : NpmPackageProjectGenerator() {
    private val packageName = "blitz"
    private val executable = "blitz"
    private val newCommand = "new"

    override fun getName(): String {
        return BlitzBundle.message("blitz.project.generator.name")
    }

    override fun getDescription(): String {
        return BlitzBundle.message("blitz.project.generator.description")
    }

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> {
        return emptyArray()
    }

    override fun customizeModule(p0: VirtualFile, p1: ContentEntry?) {}

    override fun packageName(): String {
        return packageName
    }

    override fun presentablePackageName(): String {
        return BlitzBundle.message("blitz.project.generator.presentable.package.name")
    }

    override fun getNpxCommands(): List<NpxPackageDescriptor.NpxCommand> {
        return listOf(NpxPackageDescriptor.NpxCommand(packageName, executable))
    }

    override fun generateInTemp(): Boolean {
        return true
    }

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?): Array<String> {
        return arrayOf(newCommand, project?.name.toString())
    }

    override fun getIcon(): Icon {
        return BlitzIcons.ProjectGenerator
    }
}
