package org.yasu.yasulin

import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory
import org.bukkit.plugin.java.JavaPlugin
import org.yasu.yasulin.commands.PearlShot
import org.yasu.yasulin.commands.Settings
import org.yasu.yasulin.listeners.InventoryClick
import org.yasu.yasulin.listeners.InventoryClose
import org.yasu.yasulin.listeners.ShootBow
import java.util.UUID

class Yasulin : JavaPlugin() {

    companion object {
        val guiMap: MutableMap<UUID, Inventory> = mutableMapOf()
    }

    override fun onEnable() {
        logger.info("loaded plugin")

        registerCommands()
        registerListeners()
    }

    private fun registerCommands() {
        getCommand("pearlshot")?.setExecutor(PearlShot())
        getCommand("settings")?.setExecutor(Settings())
        logger.info("loaded commands")
    }

    private fun registerListeners() {
        server.pluginManager.registerEvents(ShootBow(), this)
        Bukkit.getServer().pluginManager.registerEvents(InventoryClose(), this)
        Bukkit.getServer().pluginManager.registerEvents(InventoryClick(), this)
        logger.info("loaded listeners")
    }

    override fun onDisable() {
        logger.info("unloaded plugin")
    }
}