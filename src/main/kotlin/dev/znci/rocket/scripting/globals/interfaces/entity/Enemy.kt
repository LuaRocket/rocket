package dev.znci.rocket.scripting.globals.interfaces.entity

import org.bukkit.entity.Enemy

@Suppress("unused")
interface Enemy<T> : LivingEntity<T> where T: Enemy