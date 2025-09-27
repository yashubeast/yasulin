package org.yasu.yasulin.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.yasu.yasulin.items.ItemRegistry

class LisItem : Listener {

    @EventHandler
    fun onShootBow(event: EntityShootBowEvent) {

        val player = event.entity as? Player?: return
        val item = ItemRegistry.fromItemStack(player.inventory.itemInMainHand)?: return
        item.onShootBow(player, event)
    }

    @EventHandler
    fun onRMB(event: PlayerInteractEvent) {

        val player = event.player
        val item = ItemRegistry.fromItemStack(event.item)?: return

        if(event.action.name.contains("RIGHT_CLICK")) {
            item.onRMB(player)
        }
    }
}