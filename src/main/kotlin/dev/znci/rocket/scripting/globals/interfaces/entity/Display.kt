package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.classes.BaseLuaEntity
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeFunction
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.Color

abstract class BaseDisplayEntity<T : org.bukkit.entity.Display>(entity: T):
    BaseLuaEntity<T>(entity),
    Display<T>

@Suppress("unused")
interface Display<T> : Entity<T> where T: org.bukkit.entity.Display {
    // TODO: Implement Transformation
    @TwineNativeProperty
    var interpolationDuration: Int
        get() = entity.interpolationDuration
        set(value) {
            entity.interpolationDuration = value
        }

    @TwineNativeProperty
    var teleportDuration: Int
        get() = entity.teleportDuration
        set(value) {
            entity.teleportDuration = value
        }

    @TwineNativeProperty
    var viewRange: Float
        get() = entity.viewRange
        set(value) {
            entity.viewRange = value
        }

    @TwineNativeProperty
    var shadowRadius: Float
        get() = entity.shadowRadius
        set(value) {
            entity.shadowRadius = value
        }

    @TwineNativeProperty
    var displayWidth: Float
        get() = entity.displayWidth
        set(value) {
            entity.displayWidth = value
        }

    @TwineNativeProperty
    var displayHeight: Float
        get() = entity.displayHeight
        set(value) {
            entity.displayHeight = value
        }

    @TwineNativeProperty
    var interpolationDelay: Int
        get() = entity.interpolationDelay
        set(value) {
            entity.interpolationDelay = value
        }

    @TwineNativeProperty
    var billboard: TwineEnumValue
        get() {
            return entity.billboard.toLua()
        }
        set(value) {
            entity.billboard = value.toJava() as org.bukkit.entity.Display.Billboard
        }

    // TODO: Implement colors
    @TwineNativeFunction
    fun setGlowColor(r: Int, g: Int, b: Int) {
        entity.glowColorOverride = Color.fromRGB(r, g, b)
    }

    @TwineNativeProperty
    val glowColor: List<Int>
        get() = listOf(
            entity.glowColorOverride?.red ?: 0,
            entity.glowColorOverride?.green ?: 0,
            entity.glowColorOverride?.blue ?: 0
        )

    // TODO: Implement Brightness
}