package dev.znci.rocket.scripting.globals.interfaces.entity

import org.bukkit.entity.Creature

@Suppress("unused")
interface Mob<T> : LivingEntity<T> where T: Creature