package org.yasu.yasulin.items.misc

import org.bukkit.Material
import org.bukkit.entity.EnderPearl
import org.bukkit.entity.Player
import org.bukkit.event.entity.EntityShootBowEvent
import org.yasu.yasulin.items.ItemBase

class PearlShot : ItemBase() {

    override val material: Material = Material.BOW
    override val name = "Pearl Shot"

    override fun onShootBow(player: Player, event: EntityShootBowEvent) {

        event.isCancelled = true
        val projectile = player.launchProjectile(EnderPearl::class.java, event.projectile.velocity)
        projectile.shooter = player
    }
}