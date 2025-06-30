package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeProperty

@Suppress("unused")
interface Tameable<T> : Animals<T> where T: org.bukkit.entity.Tameable {
    @TwineNativeProperty
    var tamed: Boolean
        get() = entity.isTamed
        set(value) {
            entity.isTamed = value
        }
}