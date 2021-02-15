package kr.myoung2.hrp

import kr.myoung2.hrp.commands.HRCommand
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.hrp.listeners.GUIClickedListener
import java.io.File

class HRP : JavaPlugin(){

    private val manager = server.pluginManager

    private var hrpFile: File? = null
    private var hrpConfiguration: FileConfiguration? = null

    override fun onEnable() {
        load()
        super.onEnable()

        getCommand("hr")?.setExecutor(HRCommand())
        manager.registerEvents(GUIClickedListener(), this)
    }

    override fun onDisable() {
        save()
        super.onDisable()
    }

    private fun load() {
        hrpFile = File(dataFolder, "hrpConfig.yml").also {
            if (!it.exists()) {
                hrpConfiguration?.save(it)
            }

            hrpConfiguration?.load(it)
        }
        hrpConfiguration = YamlConfiguration.loadConfiguration(hrpFile!!)
    }

    private fun save() {
        hrpConfiguration?.save(hrpFile!!)
    }

    fun hrpConfig(): FileConfiguration {
        return hrpConfiguration!!
    }
}