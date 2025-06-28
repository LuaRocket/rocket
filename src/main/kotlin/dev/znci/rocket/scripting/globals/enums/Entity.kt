package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum
import org.bukkit.entity.EntityType

@Global
@Suppress("unused")
class LuaEntity : TwineEnum(EntityType::class)