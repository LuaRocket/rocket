package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.twine.annotations.TwineNativeProperty
import io.papermc.paper.entity.Bucketable

@Suppress("unused")
interface Bucketable<T> : Entity<T> where T: Bucketable {
    @TwineNativeProperty
    var fromBucket: Boolean
        get() = entity.isFromBucket
        set(value) { entity.isFromBucket = value }

    // TODO: Implement ItemStack & Sound
}