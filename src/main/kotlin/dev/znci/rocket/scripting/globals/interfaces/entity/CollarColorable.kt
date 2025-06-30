package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty
import io.papermc.paper.entity.CollarColorable

@Suppress("unused")
interface CollarColorable<T> : LivingEntity<T> where T: CollarColorable {
    @TwineNativeProperty
    var collarColor: TwineEnumValue
        get() {
            return entity.collarColor.toLua()
        }
        set(value) {
            entity.collarColor = value.toJava() as org.bukkit.DyeColor
        }
}