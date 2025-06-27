package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Breedable

@Suppress("unused")
interface Breedable<T> : Ageable<T> where T : Breedable {

    @TwineNativeProperty
    var ageLock: Boolean
        get() = entity.ageLock
        set(value) {
            entity.ageLock = value
        }

    @TwineNativeProperty
    var canBreed: Boolean
        get() = entity.canBreed()
        set(value) {
            entity.setBreed(value)
        }
}
