package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum

@Suppress("unused")
enum class GameMode(val bukkitValue: org.bukkit.GameMode) {
    CREATIVE(org.bukkit.GameMode.CREATIVE),
    SURVIVAL(org.bukkit.GameMode.SURVIVAL),
    ADVENTURE(org.bukkit.GameMode.ADVENTURE),
    SPECTATOR(org.bukkit.GameMode.SPECTATOR),
}

@Global
@Suppress("unused")
class LuaGameMode : TwineEnum(GameMode::class)