package org.yasu.yasulin.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.yasu.yasulin.guis.GuiManager
import org.yasu.yasulin.guis.GuiSettings

class CmdSettings : CommandExecutor {
    override fun onCommand(
        sender: CommandSender,
        command: Command,
        label: String,
        args: Array<out String>
    ): Boolean {

        if (sender is Player) {
            GuiManager.open(sender, GuiSettings(sender))
        }
        return true
    }
}