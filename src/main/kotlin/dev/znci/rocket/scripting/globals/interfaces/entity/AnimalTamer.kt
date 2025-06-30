package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeProperty
import java.util.UUID

@Suppress("unused")
abstract class BaseAnimalTamerEntity<T : org.bukkit.entity.AnimalTamer>(entity: T) :
    AnimalTamer<T>

@Suppress("unused")
interface AnimalTamer<T> where T: org.bukkit.entity.AnimalTamer {
    @TwineNativeProperty
    var name: String
        get() = name
        set(value) { name = value }

    @TwineNativeProperty
    var uuid: String
        get() = uuid
        set(value) { uuid = UUID.fromString(value).toString() }
}