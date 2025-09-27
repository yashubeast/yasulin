package org.yasu.yasulin

import org.bukkit.plugin.java.JavaPlugin
import org.yasu.yasulin.commands.CmdCustomitems
import org.yasu.yasulin.commands.CmdSettings
import org.yasu.yasulin.listeners.LisInventory
import org.yasu.yasulin.listeners.LisItem

class Yasulin : JavaPlugin() {

    override fun onEnable() {
        logger.info("loaded plugin")

        registerCommands()
        registerListeners()
    }

    private fun registerCommands() {
        getCommand("customitems")?.setExecutor(CmdCustomitems())
        getCommand("settings")?.setExecutor(CmdSettings())
        logger.info("loaded commands")
    }

    private fun registerListeners() {
        server.pluginManager.registerEvents(LisItem(), this)
        server.pluginManager.registerEvents(LisInventory(), this)
        logger.info("loaded listeners")
    }

    override fun onDisable() {
        logger.info("unloaded plugin")
    }
}