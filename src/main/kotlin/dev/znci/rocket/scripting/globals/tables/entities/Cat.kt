package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.enums.CatVariant
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAnimalEntity
import dev.znci.rocket.scripting.globals.interfaces.entity.CollarColorable
import dev.znci.rocket.scripting.globals.interfaces.entity.Sittable
import dev.znci.rocket.scripting.globals.interfaces.entity.Tameable
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Cat
import org.bukkit.entity.EntityType

// TODO: Clean this up (for some reason the cat variant is an interface not an enum??)
// (which breaks twine right now)
@Suppress("unused")
@Entity(EntityType.CAT)
class Cat(entity: Cat):
    BaseAnimalEntity<Cat>(entity),
    Tameable<Cat>,
    Sittable<Cat>,
    CollarColorable<Cat> {
        @TwineNativeProperty
        var variant: TwineEnumValue
            get() {
                return CatVariant.fromBukkit(entity.catType).toLua()
            }
            set(value) {
                var catType: Cat.Type = Cat.Type.TABBY
                when (value.name) {
                    "TABBY" -> catType = Cat.Type.TABBY
                    "BLACK" -> catType = Cat.Type.BLACK
                    "RED" -> catType = Cat.Type.RED
                    "SIAMESE" -> catType = Cat.Type.SIAMESE
                    "BRITISH_SHORTHAIR" -> catType = Cat.Type.BRITISH_SHORTHAIR
                    "CALICO" -> catType = Cat.Type.CALICO
                    "PERSIAN" -> catType = Cat.Type.PERSIAN
                    "RAGDOLL" -> catType = Cat.Type.RAGDOLL
                    "WHITE" -> catType = Cat.Type.WHITE
                    "JELLIE" -> catType = Cat.Type.JELLIE
                    "ALL_BLACK" -> catType = Cat.Type.ALL_BLACK
                    else -> error("Unknown Cat variant: ${value.name}")
                }
                entity.catType = catType
            }

        @TwineNativeProperty
        var lyingDown: Boolean
            get() = entity.isLyingDown
            set(value) {
                entity.isLyingDown = value
            }

        @TwineNativeProperty
        var headUp: Boolean
            get() = entity.isHeadUp
            set(value) {
                entity.isHeadUp = value
            }
    }
