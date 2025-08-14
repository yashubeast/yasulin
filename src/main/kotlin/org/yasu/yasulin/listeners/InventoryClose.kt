package org.yasu.yasulin.listeners

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryCloseEvent
import org.yasu.yasulin.Yasulin

class InventoryClose : Listener {

    @EventHandler
    fun inventoryClose(event: InventoryCloseEvent) {

        val playerUUID = event.player.uniqueId

        if (Yasulin.guiMap.containsKey(playerUUID)) Yasulin.guiMap.remove(playerUUID)

    }

}