package dev.znci.rocket.scripting.globals.interfaces.entity

import org.bukkit.entity.WaterMob

interface WaterMob<T> : Creature<T> where T: WaterMob
