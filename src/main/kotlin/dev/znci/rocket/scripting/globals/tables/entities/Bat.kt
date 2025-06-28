package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAmbientEntity
import dev.znci.rocket.scripting.globals.tables.LuaLocation
import dev.znci.rocket.scripting.globals.tables.LuaLocation.Companion.toLua
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.Bat
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.BAT)
class Bat(entity: Bat):
    BaseAmbientEntity<Bat>(entity) {
        @TwineNativeProperty
        var awake: Boolean
            get() = entity.isAwake
            set(value) {
                entity.isAwake = value
            }

        @TwineNativeProperty
        var targetLocation: LuaLocation
            get() = entity.targetLocation!!.toLua()
            set(value) {
                entity.targetLocation = value.toJava()
            }
    }