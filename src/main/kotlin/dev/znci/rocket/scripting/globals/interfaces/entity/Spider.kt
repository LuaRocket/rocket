package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity

abstract class BaseSpiderEntity<T : org.bukkit.entity.Spider>(entity: T) :
    BaseLuaEntity<T>(entity),
    Spider<T>

@Suppress("unused")
interface Spider<T> : Monster<T> where T: org.bukkit.entity.Spider