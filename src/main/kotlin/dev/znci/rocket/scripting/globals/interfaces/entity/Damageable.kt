package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeFunction
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Damageable

@Suppress("unused")
interface Damageable<T> where T: Damageable {
    val entity: T

    @TwineNativeFunction
    fun damage(health: Double) {
        entity.damage(health)
    }

    @TwineNativeProperty
    var health: Double
        get() = entity.health
        set(value) {
            entity.health = value
        }

    @TwineNativeFunction
    fun heal(health: Double) {
        entity.heal(health)
    }

    @TwineNativeProperty
    var absorptionAmount: Double
        get() = entity.absorptionAmount
        set(value) {
            entity.absorptionAmount = value
        }
}