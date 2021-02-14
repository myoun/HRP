package kr.myoung2.hrp

import kr.myoung2.hrp.commands.HRCommand
import org.bukkit.plugin.java.JavaPlugin

class HRP : JavaPlugin(){

    override fun onEnable() {
        getCommand("HR")?.setExecutor(HRCommand())
        getCommand("hr")?.setExecutor(HRCommand())
        super.onEnable()

        TODO("Create Package and Make Event Listener")

        /* TODO
            InventoryClickEvent
            Cancel Event
            자세한 내용은 kr.myoung2.hrp.commands.HRCommand 를 확인하세요
         */


    }
}