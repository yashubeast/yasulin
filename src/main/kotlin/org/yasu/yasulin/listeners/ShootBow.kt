package org.yasu.yasulin.listeners

import org.bukkit.entity.EnderPearl
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityShootBowEvent

class ShootBow : Listener {

    @EventHandler
    fun shootBow(event: EntityShootBowEvent) {

        val entity = event.entity

        if (entity !is Player) return

        event.isCancelled = true

        val projectile = entity.launchProjectile(EnderPearl::class.java, event.projectile.velocity)
        projectile.shooter = entity

    }

}