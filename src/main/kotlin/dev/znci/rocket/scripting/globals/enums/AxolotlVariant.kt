package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.Axolotl

@Suppress("unused")
enum class AxolotlVariant(val bukkitValue: Axolotl.Variant) {
    LUCY(Axolotl.Variant.LUCY),
    WILD(Axolotl.Variant.WILD),
    GOLD(Axolotl.Variant.GOLD),
    CYAN(Axolotl.Variant.CYAN),
    BLUE(Axolotl.Variant.BLUE);
}

@Global
@Suppress("unused")
class LuaAxolotlVariant : TwineEnum(AxolotlVariant::class)