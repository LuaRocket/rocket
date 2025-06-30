package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum

@Suppress("unused")
enum class DyeColor(val bukkitValue: org.bukkit.DyeColor) {
    WHITE(org.bukkit.DyeColor.WHITE),
    ORANGE(org.bukkit.DyeColor.ORANGE),
    MAGENTA(org.bukkit.DyeColor.MAGENTA),
    LIGHT_BLUE(org.bukkit.DyeColor.LIGHT_BLUE),
    YELLOW(org.bukkit.DyeColor.YELLOW),
    LIME(org.bukkit.DyeColor.LIME),
    PINK(org.bukkit.DyeColor.PINK),
    GRAY(org.bukkit.DyeColor.GRAY),
    LIGHT_GRAY(org.bukkit.DyeColor.LIGHT_GRAY),
    CYAN(org.bukkit.DyeColor.CYAN),
    PURPLE(org.bukkit.DyeColor.PURPLE),
    BLUE(org.bukkit.DyeColor.BLUE),
    BROWN(org.bukkit.DyeColor.BROWN),
    GREEN(org.bukkit.DyeColor.GREEN),
    RED(org.bukkit.DyeColor.RED),
    BLACK(org.bukkit.DyeColor.BLACK)
}

@Global
@Suppress("unused")
class LuaDyeColor : TwineEnum(DyeColor::class)