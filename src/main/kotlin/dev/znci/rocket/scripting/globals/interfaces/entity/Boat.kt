package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty

abstract class BaseBoatEntity<T : org.bukkit.entity.Boat>(entity: T) :
    BaseLuaEntity<T>(entity),
    Boat<T>

@Suppress("unused")
interface Boat<T> : Vehicle<T> where T : org.bukkit.entity.Boat {
    @TwineNativeProperty
    val status: TwineEnumValue
        get() {
            return entity.status.toLua()
        }

    @TwineNativeProperty
    val material: TwineEnumValue
        get() {
            return entity.boatMaterial.toLua()
        }
}