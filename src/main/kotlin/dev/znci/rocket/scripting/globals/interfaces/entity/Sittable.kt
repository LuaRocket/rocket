package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity
import dev.znci.twine.annotations.TwineNativeProperty

@Suppress("unused")
abstract class BaseSittableEntity<T : org.bukkit.entity.Sittable>(entity: T):
    BaseLuaEntity<T>(entity),
    Sittable<T>

@Suppress("unused")
interface Sittable<T> : Entity<T> where T: org.bukkit.entity.Sittable {
    @TwineNativeProperty
    var sitting: Boolean
        get() = entity.isSitting
        set(value) {
            entity.isSitting = value
        }
}