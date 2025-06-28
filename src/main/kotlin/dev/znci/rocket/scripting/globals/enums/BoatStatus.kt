package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.Boat

@Suppress("unused")
enum class BoatStatus(val bukkitValue: Boat.Status) {
    NOT_IN_WORLD(Boat.Status.NOT_IN_WORLD),
    IN_WATER(Boat.Status.IN_WATER),
    UNDER_WATER(Boat.Status.UNDER_WATER),
    UNDER_FLOWING_WATER(Boat.Status.UNDER_FLOWING_WATER),
    ON_LAND(Boat.Status.ON_LAND),
    IN_AIR(Boat.Status.IN_AIR),
}

@Global
@Suppress("unused")
class LuaBoatStatus : TwineEnum(BoatStatus::class)