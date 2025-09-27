package org.yasu.yasulin.guis

import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack

class GuiSettings(player: Player) : GuiBase(player) {

    override val title = "Settings"
    override val items = mapOf(
        0 to ItemStack(Material.DIAMOND_CHESTPLATE)
    )

    override fun onClick(event: InventoryClickEvent) {
        when (event.currentItem?.type) {
            Material.DIAMOND_CHESTPLATE -> {
                val p = event.whoClicked as Player
                val pi = p.inventory
                pi.helmet = ItemStack(Material.DIAMOND_HELMET)
                pi.chestplate = ItemStack(Material.DIAMOND_CHESTPLATE)
                pi.leggings = ItemStack(Material.DIAMOND_LEGGINGS)
                pi.boots = ItemStack(Material.DIAMOND_BOOTS)
            }
            else -> Unit
        }
    }
}