package dev.znci.rocket.scripting.globals.enums

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.TwineEnum


@Suppress("unused")
enum class TriState(val bukkitValue: net.kyori.adventure.util.TriState) {
    NOT_SET(net.kyori.adventure.util.TriState.NOT_SET),
    TRUE(net.kyori.adventure.util.TriState.TRUE),
    FALSE(net.kyori.adventure.util.TriState.FALSE),
}

@Global
@Suppress("unused")
class LuaTriState : TwineEnum(TriState::class)