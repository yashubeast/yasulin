package org.yasu.yasulin.guis

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

abstract class GuiBase(
    val player: Player
) {

    open val title: String = "Custom Menu"
    open val size: Int = 54
    open val items: Map<Int, ItemStack> = emptyMap()

    val inventory: Inventory = Bukkit.createInventory(
        player,
        size,
        Component.text(title)
    ).apply{
        items.forEach{ (slot, item) -> setItem(slot, item) }
    }

    abstract fun onClick(event: InventoryClickEvent)
//    open fun onClose(event: InventoryCloseEvent) {}
}