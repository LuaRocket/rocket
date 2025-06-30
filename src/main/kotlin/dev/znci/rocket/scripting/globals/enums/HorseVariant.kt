package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.Horse

@Suppress("unused")
enum class HorseVariant(val bukkitValue: Horse.Style) {
    NONE(Horse.Style.NONE),
    WHITE(Horse.Style.WHITE),
    WHITEFIELD(Horse.Style.WHITEFIELD),
    WHITE_DOTS(Horse.Style.WHITE_DOTS),
    BLACK_DOTS(Horse.Style.BLACK_DOTS),
}

@Global
@Suppress("unused")
class LuaHorseVariant : TwineEnum(HorseVariant::class)