package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAnimalEntity
import dev.znci.rocket.scripting.globals.tables.LuaLocation
import dev.znci.rocket.scripting.globals.tables.LuaLocation.Companion.toLua
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty
import net.kyori.adventure.util.TriState
import org.bukkit.entity.Bee
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.BEE)
class Bee(entity: Bee):
    BaseAnimalEntity<Bee>(entity) {
        @TwineNativeProperty
        var hiveLocation: LuaLocation?
            get() = entity.hive?.toLua()
            set(value) {
                entity.hive = value?.toJava()
            }

        @TwineNativeProperty
        var flowerLocation: LuaLocation?
            get() = entity.flower?.toLua()
            set(value) {
                entity.flower = value?.toJava()
            }

        @TwineNativeProperty
        var hasNectar: Boolean
            get() = entity.hasNectar()
            set(value) {
                entity.setHasNectar(value)
            }

        @TwineNativeProperty
        var hasStung: Boolean
            get() = entity.hasStung()
            set(value) {
                entity.setHasStung(value)
            }

        @TwineNativeProperty
        var anger: Int
            get() = entity.anger
            set(value) {
                entity.anger = value
            }

        @TwineNativeProperty
        var hiveEnterCooldown: Int
            get() = entity.cannotEnterHiveTicks
            set(value) {
                entity.cannotEnterHiveTicks = value
            }

        @TwineNativeProperty
        var rollingOverride: TwineEnumValue
            get() = entity.rollingOverride.toLua()
            set(value) {
                entity.rollingOverride = value.toJava() as TriState
            }

        val rolling: Boolean
            get() = entity.isRolling

        @TwineNativeProperty
        var cropsGrownSincePollination: Int
            get() = entity.cropsGrownSincePollination
            set(value) {
                entity.cropsGrownSincePollination = value
            }

        @TwineNativeProperty
        var ticksSincePollination: Int
            get() = entity.ticksSincePollination
            set(value) {
                entity.ticksSincePollination = value
            }
    }