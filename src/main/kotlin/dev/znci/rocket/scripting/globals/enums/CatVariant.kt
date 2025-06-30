package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.Cat

@Suppress("unused")
enum class CatVariant(val bukkitValue: Cat.Type) {
    TABBY(Cat.Type.TABBY),
    BLACK(Cat.Type.BLACK),
    RED(Cat.Type.RED),
    SIAMESE(Cat.Type.SIAMESE),
    BRITISH_SHORTHAIR(Cat.Type.BRITISH_SHORTHAIR),
    CALICO(Cat.Type.CALICO),
    PERSIAN(Cat.Type.PERSIAN),
    RAGDOLL(Cat.Type.RAGDOLL),
    WHITE(Cat.Type.WHITE),
    JELLIE(Cat.Type.JELLIE),
    ALL_BLACK(Cat.Type.ALL_BLACK);

    companion object {
        fun fromBukkit(type: Cat.Type): CatVariant =
            entries.firstOrNull { it.bukkitValue == type }
                ?: error("Unknown Bukkit Cat.Type: $type")
    }
}

@Global
@Suppress("unused")
class LuaCatVariant : TwineEnum(CatVariant::class)