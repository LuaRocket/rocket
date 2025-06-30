package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity
import dev.znci.twine.annotations.TwineNativeProperty

abstract class BaseAbstractHorseEntity<T : org.bukkit.entity.AbstractHorse>(entity: T) :
    BaseLuaEntity<T>(entity),
    AbstractHorse<T>

@Suppress("unused")
interface AbstractHorse<T> : Vehicle<T> where T: org.bukkit.entity.AbstractHorse {
    @TwineNativeProperty
    var domestication: Int
        get() = entity.domestication
        set(value) {
            entity.domestication = value
        }

    @TwineNativeProperty
    var maxDomestication: Int
        get() = entity.maxDomestication
        set(value) {
            entity.maxDomestication = value
        }

    @TwineNativeProperty
    var jumpStrength: Double
        get() = entity.jumpStrength
        set(value) {
            entity.jumpStrength = value
        }

    @TwineNativeProperty
    var eatingGrass: Boolean
        get() = entity.isEatingGrass
        set(value) {
            entity.isEatingGrass = value
        }

    @TwineNativeProperty
    var rearing: Boolean
        get() = entity.isRearing
        set(value) {
            entity.isRearing = value
        }

    @TwineNativeProperty
    var eating: Boolean
        get() = entity.isEating
        set(value) {
            entity.isEating = value
        }
}