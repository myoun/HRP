package org.projecttl.plugin.hrp.listeners

import kr.myoung2.hrp.HRP
import kr.myoung2.hrp.commands.HRCommand
import org.bukkit.ChatColor
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class GUIClickedListener(private val plugin: HRP): Listener {

    @EventHandler
    fun guiClickedEvent(event: InventoryClickEvent) {
        val player = event.whoClicked

        if (event.view.title.equals(HRCommand(plugin).inventoryName, ignoreCase = true)) {
            when (event.currentItem?.itemMeta?.displayName) {
                HRCommand(plugin).diamondSword -> {
                }

                HRCommand(plugin).ironChestPlate -> {
                }

                HRCommand(plugin).goldenPickaxe -> {
                }

                HRCommand(plugin).leatherBoots -> {
                }

                "${ChatColor.DARK_RED}Exit" -> {
                    player.closeInventory()
                }
            }

            event.isCancelled = true
        }
    }
}