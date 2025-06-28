package dev.znci.rocket.scripting.globals.interfaces.entity

import org.bukkit.entity.Creature

interface Creature<T> : Mob<T> where T: Creature
