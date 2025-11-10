package dev.znci.rocket.scripting.globals.enums

import org.bukkit.entity.Chicken

@Suppress("unused")
enum class ChickenVariant(val bukkitValue: Chicken.Variant) {
    COLD(Chicken.Variant.COLD),
    TEMPERATE(Chicken.Variant.TEMPERATE),
    WARM(Chicken.Variant.WARM);

    companion object {
        fun fromBukkit(type: Chicken.Variant): ChickenVariant =
            ChickenVariant.entries.firstOrNull { it.bukkitValue == type }
                ?: error("Unknown Bukkit Chicken.Variant: $type")
    }
}