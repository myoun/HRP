package kr.myoung2.hrp

import org.bukkit.plugin.java.JavaPlugin
import org.projecttl.plugin.hrp.TestClass

class HRP : JavaPlugin(){

    override fun onEnable() {
        TestClass().testLet()
        super.onEnable()
    }
}