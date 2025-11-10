package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.enums.ChickenVariant
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAnimalEntity
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Chicken
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.CHICKEN)
class Chicken(entity: Chicken):
    BaseAnimalEntity<Chicken>(entity) {
        @TwineNativeProperty
        var variant: TwineEnumValue
            get() {
                return ChickenVariant.fromBukkit(entity.variant).toLua()
            }
            set(value) {
                var chickenType: Chicken.Variant = Chicken.Variant.COLD
                when (value.name) {
                    "COLD" -> chickenType = Chicken.Variant.COLD
                    "TEMPERATE" -> chickenType = Chicken.Variant.TEMPERATE
                    "WARM" -> chickenType = Chicken.Variant.WARM
                    else -> error("Unknown Chicken variant: ${value.name}")
                }
                entity.variant = chickenType
            }
    }