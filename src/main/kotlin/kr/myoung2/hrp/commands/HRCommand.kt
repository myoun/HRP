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


    val inventoryName: String = "${ChatColor.RED}인간 ${ChatColor.BLUE}강화"

    val diamondSword: String = "${ChatColor.AQUA}날카로운 검"
    val ironChestPlate: String = "${ChatColor.AQUA}단단한 갑옷"
    val goldenPickaxe: String = "${ChatColor.GOLD}빠른 곡괭이"
    val leatherBoots: String = "${ChatColor.GREEN}빠른 발걸음"

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            if (command.name == "hr") {
                if (args.isNullOrEmpty()) {
                    val hrgUI: CreateGUI = CreateGUI(27, inventoryName).let {
                        it.setItem(ItemStack(Material.DIAMOND_SWORD), diamondSword, 10)
                        it.setItem(ItemStack(Material.IRON_CHESTPLATE), ironChestPlate, 12)
                        it.setItem(ItemStack(Material.GOLDEN_PICKAXE), goldenPickaxe, 14)
                        it.setItem(ItemStack(Material.LEATHER_BOOTS), leatherBoots,16)
                        it.setExitButton(22)

                        it
                    }

                    hrgUI.openInventory(sender)
                    return true
                }
            }
        } else {
            return true
        }

        return false
    }
}