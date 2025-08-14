package org.yasu.yasulin.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class PearlShot : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) return false
        if (!sender.isOp) return false

        val testItem = ItemStack(Material.BOW)
        val itemMeta = testItem.itemMeta
        itemMeta.displayName(Component.text("Pearl Shot").color(TextColor.color(68, 68, 68)))

        testItem.itemMeta = itemMeta

        sender.inventory.addItem(testItem)

        return false
    }
}