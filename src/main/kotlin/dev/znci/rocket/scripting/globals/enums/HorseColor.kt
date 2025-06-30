package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.Horse

@Suppress("unused")
enum class HorseColor(val bukkitValue: Horse.Color) {
    WHITE(Horse.Color.WHITE),
    CREAMY(Horse.Color.CREAMY),
    CHESTNUT(Horse.Color.CHESTNUT),
    BROWN(Horse.Color.BROWN),
    BLACK(Horse.Color.BLACK),
    GRAY(Horse.Color.GRAY),
    DARK_BROWN(Horse.Color.DARK_BROWN)
}

@Global
@Suppress("unused")
class LuaHorseColor : TwineEnum(HorseColor::class)