package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.Display

enum class Billboard(val bukkitValue: Display.Billboard) {
    CENTER(Display.Billboard.CENTER),
    VERTICAL(Display.Billboard.VERTICAL),
    HORIZONTAL(Display.Billboard.HORIZONTAL),
    FIXED(Display.Billboard.FIXED),
}

@Global
@Suppress("unused")
open class LuaBillboard() : TwineEnum(Billboard::class)