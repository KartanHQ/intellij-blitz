package com.nekofar.milad.intellij.blitz.cli

import com.intellij.execution.filters.Filter
import com.intellij.lang.javascript.boilerplate.NpmPackageProjectGenerator
import com.intellij.lang.javascript.boilerplate.NpxPackageDescriptor
import com.intellij.openapi.project.Project
import com.intellij.openapi.roots.ContentEntry
import com.intellij.openapi.vfs.VirtualFile
import com.nekofar.milad.intellij.blitz.BlitzBundle.message
import com.nekofar.milad.intellij.blitz.BlitzIcons

class BlitzCliProjectGenerator : NpmPackageProjectGenerator() {
    private data class PackageInfo(val name: String, val executable: String, val command: String)

    private val packageInfo = PackageInfo("blitz", "blitz", "new")
    override fun getName() = message("blitz.project.generator.name")

    override fun getDescription() = message("blitz.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile) = emptyArray<Filter>()

    override fun customizeModule(virtualFile: VirtualFile, contentEntry: ContentEntry?) {}

    override fun packageName() = packageInfo.name

    override fun presentablePackageName() = message("blitz.project.generator.presentable.package.name")

    override fun getNpxCommands() = listOf(NpxPackageDescriptor.NpxCommand(packageName(), packageInfo.executable))

    override fun generateInTemp() = true

    override fun generatorArgs(project: Project, baseDir: VirtualFile) = arrayOf(packageInfo.command, project.name)

    override fun getIcon() = BlitzIcons.ProjectGenerator
}
