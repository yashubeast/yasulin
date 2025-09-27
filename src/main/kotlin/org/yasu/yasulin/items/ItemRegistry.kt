package org.yasu.yasulin.items

import org.bukkit.inventory.ItemStack
import org.yasu.yasulin.items.misc.PearlShot

object ItemRegistry {

    val all: List<ItemBase> = listOf(
        PearlShot()
        // add more items
    )

    fun fromItemStack(stack: ItemStack?): ItemBase? {
        if(stack == null) return null
        return all.firstOrNull{ it.item.isSimilar(stack) }
    }
}