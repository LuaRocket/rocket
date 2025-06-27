package dev.znci.rocket.scripting.globals.tables

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.annotations.TwineNativeFunction
import dev.znci.twine.annotations.TwineNativeProperty
import dev.znci.twine.nativex.TwineNative
import org.bukkit.Color

@Global
@Suppress("unused")
class LuaColors : TwineNative("color") {
    @TwineNativeFunction("argb")
    fun fromARGB(alpha: Int, red: Int, green: Int, blue: Int): LuaColor {
        return LuaColor(alpha, red, green, blue)
    }
}

@Suppress("unused")
class LuaColor(
    private var colorAlpha: Int,
    private var colorRed: Int,
    private var colorGreen: Int,
    private var colorBlue: Int
) : TwineNative() {
    @TwineNativeProperty("a")
    var alpha: Int
        get() = colorAlpha
        set(value) {
            colorAlpha = value
        }

    @TwineNativeProperty("r")
    var red: Int
        get() = colorRed
        set(value) {
            colorRed = value
        }

    @TwineNativeProperty("g")
    var blue: Int
        get() = colorBlue
        set(value) {
            colorBlue = value
        }

    @TwineNativeProperty("b")
    var green: Int
        get() = colorGreen
        set(value) {
            colorGreen = value
        }

    @TwineNativeFunction
    override fun toString(): String {
        return "color[a=$colorAlpha, r=$colorRed, g=$colorGreen, b=$colorBlue]"
    }

    companion object {
        fun Color.toLua(): LuaColor {
            return LuaColor(
                colorAlpha = this.alpha,
                colorRed = this.red,
                colorBlue = this.blue,
                colorGreen = this.green,
            )
        }
    }

    fun toJava(): Color {
        return Color.fromARGB(this.colorAlpha, this.colorRed, this.colorBlue, this.colorGreen)
    }
}