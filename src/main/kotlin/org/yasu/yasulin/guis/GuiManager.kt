package org.yasu.yasulin.guis

import org.bukkit.entity.Player
import java.util.UUID

object GuiManager {

    private val openGuis = mutableMapOf<UUID, GuiBase>()

    fun open(player: Player, gui: GuiBase) {
        openGuis[player.uniqueId] = gui
        player.openInventory(gui.inventory)
    }

    fun get(player: Player) = openGuis[player.uniqueId]
    fun close(player: Player) { openGuis.remove(player.uniqueId) }

}