package org.yasu.yasulin.items

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityShootBowEvent
import org.bukkit.inventory.ItemStack

abstract class ItemBase {

    abstract val material: Material
    open val name: String = "unnamed item"
    open val color: TextColor? = null

    val item: ItemStack by lazy{
        ItemStack(material).apply{
            itemMeta = itemMeta.apply{
                val comp = Component.text(name)
                customName(if(color != null) comp.color(color) else comp)
            }
        }
    }

    open fun onRMB(player: Player) {}
    open fun onShootBow(player: Player, event: EntityShootBowEvent) {}
}