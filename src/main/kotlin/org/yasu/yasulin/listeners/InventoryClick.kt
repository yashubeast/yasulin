package org.yasu.yasulin.listeners

import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.yasu.yasulin.Yasulin

class InventoryClick : Listener {

    @EventHandler
    fun inventoryClick(event: InventoryClickEvent) {

        val player = event.whoClicked
        val playerUUID = event.whoClicked.uniqueId

        if (event.inventory == Yasulin.guiMap[playerUUID]) {

            if (event.currentItem == null) return

            when (event.currentItem!!.type) {
                Material.DIAMOND_CHESTPLATE -> {
                    player.inventory.helmet = ItemStack(Material.DIAMOND_HELMET)
                    player.inventory.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                    player.inventory.leggings = ItemStack(Material.DIAMOND_LEGGINGS)
                    player.inventory.boots = ItemStack(Material.DIAMOND_BOOTS)

                    event.inventory.close()
                }

                else -> {}
            }

            event.isCancelled = true
        }

    }

}