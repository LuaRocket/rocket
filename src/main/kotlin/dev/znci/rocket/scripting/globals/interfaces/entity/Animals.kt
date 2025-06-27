package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity
import dev.znci.twine.annotations.TwineNativeProperty
import java.util.UUID

abstract class BaseAnimalEntity<T : org.bukkit.entity.Animals>(entity: T) :
    BaseLuaEntity<T>(entity),
    Animals<T>

@Suppress("unused")
interface Animals<T> : Breedable<T> where T: org.bukkit.entity.Animals {
    @TwineNativeProperty
    var breedCause: String
        get() = entity.breedCause.toString()
        set(value) { entity.breedCause = UUID.fromString(value) }

    @TwineNativeProperty
    val loveMode: Boolean
        get() = entity.isLoveMode

    @TwineNativeProperty
    var loveModeTicks: Int
        get() = entity.loveModeTicks
        set(value) {
            entity.loveModeTicks = value
        }

    // TODO: Add isBreedItem once ItemStacks are implemented
}