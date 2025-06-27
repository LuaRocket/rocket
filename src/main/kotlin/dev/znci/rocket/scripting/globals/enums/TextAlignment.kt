package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.TextDisplay

@Suppress("unused")
enum class TextAlignment(val bukkitValue: TextDisplay.TextAlignment) {
    CENTER(TextDisplay.TextAlignment.CENTER),
    LEFT(TextDisplay.TextAlignment.LEFT),
    RIGHT(TextDisplay.TextAlignment.RIGHT),
}

@Global
@Suppress("unused")
class LuaTextAlignment : TwineEnum(TextAlignment::class) {}