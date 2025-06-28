package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity
import dev.znci.twine.annotations.TwineNativeProperty

abstract class BaseAbstractSkeletonEntity<T : org.bukkit.entity.AbstractSkeleton>(entity: T) :
    BaseLuaEntity<T>(entity),
    AbstractSkeleton<T>

@Suppress("unused")
interface AbstractSkeleton<T> : Monster<T> where T: org.bukkit.entity.AbstractSkeleton {
    @TwineNativeProperty
    var burnInDay: Boolean
        get() {
            return entity.shouldBurnInDay()
        }
        set(value) {
            entity.setShouldBurnInDay(value)
        }
}