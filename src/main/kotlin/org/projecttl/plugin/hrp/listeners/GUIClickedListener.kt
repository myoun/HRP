package org.projecttl.plugin.hrp.listeners

import kr.myoung2.hrp.commands.HRCommand
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class GUIClickedListener: Listener {

    @EventHandler
    fun guiClickedEvent(event: InventoryClickEvent) {
        val player = event.whoClicked

        if (event.view.title.equals(HRCommand().inventoryName, ignoreCase = true)) {
            when (event.currentItem?.itemMeta?.displayName) {
                HRCommand().diamondSword -> {
                }

                HRCommand().ironChestPlate -> {
                }

                HRCommand().goldenPickaxe -> {
                }

                HRCommand().ironChestPlate2 -> {
                }
            }

            event.isCancelled = true
        }
    }
}