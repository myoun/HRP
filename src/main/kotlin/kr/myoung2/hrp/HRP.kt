package kr.myoung2.hrp

import kr.myoung2.hrp.commands.HRCommand
import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.hrp.TestClass

class HRP : JavaPlugin(){

    override fun onEnable() {
        getCommand("HR")?.setExecutor(HRCommand())
        getCommand("hr")?.setExecutor(HRCommand())

        super.onEnable()
    }
}