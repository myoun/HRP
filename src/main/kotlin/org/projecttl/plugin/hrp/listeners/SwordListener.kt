package org.projecttl.plugin.hrp.listeners

import kr.myoung2.hrp.HRP
import org.bukkit.Material
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDropItemEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.inventory.ItemStack

class SwordListener(private val plugin: HRP): Listener {

    private val path: Int = plugin.hrpConfig().getInt("sword.enchantment.level")
    private val fixEnchantment: Enchantment = Enchantment.DAMAGE_ALL

    @EventHandler
    fun playerPickupSword(event: EntityPickupItemEvent) {
        if (event.entityType == EntityType.PLAYER) {
            val item = event.item
            val itemStack = item.itemStack

            if (itemStack.enchantments.containsKey(fixEnchantment)) {
                if (itemStack.enchantments[fixEnchantment]!! > path) {
                    return
                } else {
                    isEnchant(itemStack, false)
                }
            }

            if (checkSword(itemStack)) {
                isEnchant(itemStack, true)
            }

            item.itemStack = itemStack
        } else {
            return
        }
    }

    @EventHandler
    fun playerDropSword(event: EntityDropItemEvent) {
        if (event.entityType == EntityType.PLAYER) {
            val item: Item = event.itemDrop
            val itemStack = item.itemStack

            if (itemStack.enchantments.containsKey(fixEnchantment)) {
                if (itemStack.enchantments[fixEnchantment]!! > path) {
                    return
                } else {
                    isEnchant(itemStack, false)
                }
            }

            item.itemStack = itemStack
        }
    }

    private fun checkSword(item: ItemStack): Boolean {
        return when (item.type) {
            Material.WOODEN_SWORD -> true
            Material.STONE_SWORD  -> true
            Material.IRON_SWORD -> true
            Material.GOLDEN_SWORD -> true
            Material.DIAMOND_SWORD -> true
            Material.NETHERITE_SWORD -> true

            else -> false
        }
    }

    private fun isEnchant(item: ItemStack, setEnchant: Boolean) {
        if (!setEnchant) {
            item.removeEnchantment(Enchantment.DAMAGE_ALL)
        } else {
            item.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, path)
        }
    }
}