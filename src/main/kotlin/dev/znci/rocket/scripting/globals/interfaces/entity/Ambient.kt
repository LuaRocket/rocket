package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity

abstract class BaseAmbientEntity<T : org.bukkit.entity.Ambient>(entity: T) :
    BaseLuaEntity<T>(entity),
    Ambient<T>

@Suppress("unused")
interface Ambient<T> : Mob<T> where T: org.bukkit.entity.Ambient