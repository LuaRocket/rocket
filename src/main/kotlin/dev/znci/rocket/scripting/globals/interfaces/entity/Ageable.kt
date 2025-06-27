package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Ageable

@Suppress("unused")
interface Ageable<T> : Creature<T> where T : Ageable {

    @TwineNativeProperty
    var age: Int
        get() = entity.age
        set(value) {
            entity.age = value
        }

    @TwineNativeProperty
    var adult: Boolean
        get() = entity.isAdult
        set(value) {
            if (value) {
                entity.setAdult()
            } else {
                entity.setBaby()
            }
        }
}
