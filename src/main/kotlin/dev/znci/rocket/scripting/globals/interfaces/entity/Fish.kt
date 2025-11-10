package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity

abstract class BaseFishEntity<T : org.bukkit.entity.Fish>(entity: T) :
    BaseLuaEntity<T>(entity),
    Fish<T>

interface Fish<T> : WaterMob<T>, Bucketable<T> where T: org.bukkit.entity.Fish
