package kr.myoung2.hrp

import kr.myoung2.hrp.commands.HRCommand
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.hrp.listeners.GUIClickedListener

class HRP : JavaPlugin(){

    val manager = server.pluginManager

    override fun onEnable() {
        getCommand("HR")?.setExecutor(HRCommand())
        getCommand("hr")?.setExecutor(HRCommand())

        manager.registerEvents(GUIClickedListener(), this)

        super.onEnable()
    }
}