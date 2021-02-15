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

    override fun onEnable() {
        config.addDefault("armor.enchantment.level",2)
        config.addDefault("sword.enchantment.level",2)
        getCommand("hr")?.setExecutor(HRCommand(this))
        getCommand("hr")?.tabCompleter = ArgumentForHRCommand()
        saveConfig()
        manager.registerEvents(GUIClickedListener(this), this)
        manager.registerEvents(HarderArmorListener(this),this)
        manager.registerEvents(SwordListener(this),this)
        super.onEnable()
    }

    override fun onDisable() {
        saveConfig()
        super.onDisable()
    }

    fun hrpConfig(): FileConfiguration {
        return config
    }
}