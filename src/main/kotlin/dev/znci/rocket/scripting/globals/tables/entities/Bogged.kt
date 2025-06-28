package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAbstractSkeletonEntity
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Bogged
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.BOGGED)
class Bogged(entity: Bogged):
    BaseAbstractSkeletonEntity<Bogged>(entity) {
        @TwineNativeProperty
        var sheared: Boolean
            get() = entity.isSheared
            set(value) {
                entity.isSheared = value
            }
    }