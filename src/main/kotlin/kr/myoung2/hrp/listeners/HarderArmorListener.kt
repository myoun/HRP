package kr.myoung2.hrp.listeners

import kr.myoung2.hrp.HRP
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerDropItemEvent
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class HarderArmorListener(val plugin: HRP) : Listener {

    @EventHandler
    fun onPlayerGetArmor(e:EntityPickupItemEvent) {
        println("와")
        if (e.entityType != EntityType.PLAYER) return
        println("와2")
        val item:Item = e.item
        val stack:ItemStack = item.itemStack
        val enchantLevel:Int = plugin.hrpConfig().getInt("ProtectionEnchantLevel")

        if (!checkArmor(stack)) return
        println("와3")
        if (stack.enchantments.containsKey(Enchantment.PROTECTION_ENVIRONMENTAL)){
            println("와4")
            if (stack.enchantments[Enchantment.PROTECTION_ENVIRONMENTAL]!! > enchantLevel){
                println(stack.enchantments[Enchantment.PROTECTION_ENVIRONMENTAL])
                return
            }
            else {
                println(stack.enchantments[Enchantment.PROTECTION_ENVIRONMENTAL])
                stack.removeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL)
            }
        }

        stack.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL,enchantLevel)
        item.itemStack = stack
    }

    @EventHandler
    fun onPlayerDropArmor(e:PlayerDropItemEvent){
        println("와")
        val item:Item = e.itemDrop
        val stack:ItemStack = item.itemStack
        val meta:ItemMeta = stack.itemMeta
        val enchantLevel:Int = plugin.hrpConfig().getInt("ProtectionEnchantLevel")

        if (!checkArmor(stack)) return

        if (meta.enchants.containsKey(Enchantment.PROTECTION_ENVIRONMENTAL)){
            if (meta.getEnchantLevel(Enchantment.PROTECTION_ENVIRONMENTAL) > enchantLevel) return
            else meta.removeEnchant(Enchantment.PROTECTION_ENVIRONMENTAL)
        }
        stack.itemMeta = meta
        item.itemStack = stack
    }



    private fun checkArmor(item:ItemStack) : Boolean{
        return when (item.type){
            Material.LEATHER_CHESTPLATE -> true
            Material.IRON_CHESTPLATE -> true
            Material.GOLDEN_CHESTPLATE -> true
            Material.DIAMOND_CHESTPLATE -> true
            Material.NETHERITE_CHESTPLATE -> true

            else -> false
        }
    }
}