package kr.myoung2.hrp

import kr.myoung2.hrp.commands.HRCommand
import kr.myoung2.hrp.listeners.HarderArmorListener
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.hrp.commands.Void
import org.projecttl.plugin.hrp.commands.arguments.ArgumentForHRCommand
import org.projecttl.plugin.hrp.listeners.GUIClickedListener
import org.projecttl.plugin.hrp.listeners.SwordListener
import java.io.File

class HRP : JavaPlugin(){

    private val manager = server.pluginManager

    var hrpFile: File? = null
    private var hrpConfiguration: FileConfiguration? = null
    private var userFile: File? = null
    private var userdataConfig: FileConfiguration? = null

    override fun onEnable() {
        load()

        getCommand("hr")?.setExecutor(HRCommand(this))
        getCommand("hr")?.tabCompleter = ArgumentForHRCommand()

        manager.registerEvents(GUIClickedListener(), this)
        manager.registerEvents(HarderArmorListener(this),this)
        manager.registerEvents(SwordListener(this),this)
        super.onEnable()
    }

    override fun onDisable() {
        super.onDisable()
    }

    private fun load() {
        hrpFile = File(dataFolder, "hrpConfig.yml").also {
            if (!it.exists()) {
                hrpConfiguration?.set("armor.enchantment.level",2)
                hrpConfiguration?.set("sword.enchantment.level",2)
                hrpConfiguration?.save(it)

                // This is debug
                Void()
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