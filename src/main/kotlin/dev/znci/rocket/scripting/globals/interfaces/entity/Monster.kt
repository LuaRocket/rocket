package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity

abstract class BaseMonsterEntity<T : org.bukkit.entity.Monster>(entity: T) :
    BaseLuaEntity<T>(entity),
    Monster<T>

@Suppress("unused")
interface Monster<T> : Creature<T>, Enemy<T> where T: org.bukkit.entity.Monster