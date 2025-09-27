package org.yasu.yasulin.listeners

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.yasu.yasulin.guis.GuiManager

class LisInventory : Listener {

    @EventHandler
    fun inventoryClick(event: InventoryClickEvent) {

        val player = event.whoClicked as? Player?: return
        val gui = GuiManager.get(player) ?: return
        if(event.inventory != gui.inventory) return
        // is custom gui click

        event.isCancelled = true
        // call custom gui onClick
        gui.onClick(event)
    }

    @EventHandler
    fun inventoryClose(event: InventoryCloseEvent) {

        val player = event.player as? Player?: return
        GuiManager.close(player)
    }

}