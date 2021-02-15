package org.projecttl.plugin.hrp.listeners

import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerAttemptPickupItemEvent

class SwordListener: Listener {

    fun playerPickupSword(event: EntityPickupItemEvent) {
        val player: Player = event.entity as Player
    }
}