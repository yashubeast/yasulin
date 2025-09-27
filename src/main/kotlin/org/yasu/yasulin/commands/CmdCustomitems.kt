package org.yasu.yasulin.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.yasu.yasulin.guis.GuiCustomitems
import org.yasu.yasulin.guis.GuiManager

class CmdCustomitems : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {

        if (sender !is Player) return false
        if (!sender.isOp) return false
        // is OP player

        GuiManager.open(sender, GuiCustomitems(sender))
        return true

    }
}