package org.yasu.yasulin.commands

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.yasu.yasulin.Yasulin

class Settings : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {

        if (sender !is Player) return false

        val inv = Bukkit.createInventory(sender, 54, Component.text("Settings"))
        val border = ItemStack(Material.DIAMOND_CHESTPLATE)
        border.itemMeta.customName(Component.text(""))

        inv.setItem(0, border)

        Yasulin.guiMap[sender.uniqueId] = inv

        sender.openInventory(inv)

        return false

    }
}