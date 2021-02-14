package kr.myoung2.hrp.commands

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.projecttl.api.inventorygui.utils.CreateGUI

class HRCommand : CommandExecutor {

    val diamondSword: String = "${ChatColor.AQUA}날카로운 검"
    val ironChestPlate: String = "${ChatColor.AQUA}단단한 갑옷"
    val goldenPickaxe: String = "${ChatColor.GOLD}빠른 곡괭이"
    val ironChestPlate2: String = "${ChatColor.AQUA}단단해진 갑옷"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            return false
        } else {
            if (command.name == "hr") {
                val hrgUI: CreateGUI = CreateGUI(27, "${ChatColor.RED}인간 ${ChatColor.BLUE}강화").let {

                    it.setItem(ItemStack(Material.DIAMOND_SWORD), "${ChatColor.AQUA}날카로운 검", 10)
                    it.setItem(ItemStack(Material.IRON_CHESTPLATE), "${ChatColor.AQUA}단단한 갑옷", 12)
                    it.setItem(ItemStack(Material.GOLDEN_PICKAXE), "${ChatColor.GOLD}빠른 곡괭이", 14)
                    it.setItem(ItemStack(Material.IRON_CHESTPLATE), "${ChatColor.AQUA}단단해진 갑옷", 16)

                    it.setExitButton(22)

                    it
                }

                hrgUI.openInventory(sender)
                return true
            }
        }

        return false
    }
}