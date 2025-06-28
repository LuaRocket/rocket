package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAnimalEntity
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Axolotl
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.AXOLOTL)
class Axolotl(entity: Axolotl):
    BaseAnimalEntity<Axolotl>(entity) {
        @TwineNativeProperty
        var playingDead: Boolean
            get() = entity.isPlayingDead
            set(value) {
                entity.isPlayingDead = value
            }

        @TwineNativeProperty
        var variant: TwineEnumValue
            get() = entity.variant.toLua()
            set(value) {
                entity.variant = value.toJava() as Axolotl.Variant
            }
    }