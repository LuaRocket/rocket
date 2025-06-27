package dev.znci.rocket.scripting.globals.interfaces.entity

import io.papermc.paper.entity.Frictional
import org.bukkit.entity.LivingEntity

@Suppress("unused")
interface Frictional<T> where T : LivingEntity, T: Frictional {
    val entity: T

//    @TwineNativeProperty
//    val frictionState: TriState
//        get() {
//            return TriState(entity.frictionState)
//        }
}