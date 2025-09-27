package org.yasu.yasulin.guis

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.ItemStack
import org.yasu.yasulin.items.ItemRegistry

class GuiCustomitems(player: Player) : GuiBase(player) {

    override val title = "Custom Items"
    override val size = 9
    override val items: Map<Int, ItemStack> = ItemRegistry.all
        .mapIndexed{ i, item -> i to item.item }
        .toMap()

    override fun onClick(event: InventoryClickEvent) {
        event.isCancelled = true
        val player = event.whoClicked as? Player?: return
        val itemClicked = event.currentItem ?: return
        // is click on any item

        val item = ItemRegistry.fromItemStack(itemClicked)?: return
        // is click on custom item

        player.inventory.addItem(item.item.clone())
    }
}