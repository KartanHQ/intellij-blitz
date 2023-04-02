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
    private data class PackageInfo(val name: String, val executable: String, val command: String)

    private val packageInfo = PackageInfo("blitz", "blitz", "new")
    override fun getName(): String = BlitzBundle.message("blitz.project.generator.name")

    override fun getDescription(): String = BlitzBundle.message("blitz.project.generator.description")

    override fun filters(project: Project, baseDir: VirtualFile): Array<Filter> = emptyArray()

    override fun customizeModule(p0: VirtualFile, p1: ContentEntry?) {}

    override fun packageName(): String = packageInfo.name

    override fun presentablePackageName(): String =
        BlitzBundle.message("blitz.project.generator.presentable.package.name")

    override fun getNpxCommands(): List<NpxPackageDescriptor.NpxCommand> =
        listOf(NpxPackageDescriptor.NpxCommand(packageName(), packageInfo.executable))

    override fun generateInTemp(): Boolean = true

    override fun generatorArgs(project: Project?, dir: VirtualFile?, settings: Settings?): Array<String> =
        arrayOf(packageInfo.command, project?.name.orEmpty())

    override fun getIcon(): Icon = BlitzIcons.ProjectGenerator
}
