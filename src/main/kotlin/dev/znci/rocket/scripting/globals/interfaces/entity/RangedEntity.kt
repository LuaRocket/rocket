package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeFunction

@Suppress("unused")
abstract class BaseRangedEntity<T> (
    entity: T
) : BaseMobEntity<T>(entity), RangedEntity<T>
        where T : org.bukkit.entity.Mob,
              T : com.destroystokyo.paper.entity.RangedEntity

@Suppress("unused")
interface RangedEntity<T> : Mob<T> where T: com.destroystokyo.paper.entity.RangedEntity {
    @TwineNativeFunction
    fun rangedAttack(target: LivingEntity<T>, charge: Float) {
        entity.rangedAttack(target.entity, charge)
    }
}