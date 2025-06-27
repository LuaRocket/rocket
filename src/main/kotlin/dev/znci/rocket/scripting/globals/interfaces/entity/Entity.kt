package dev.znci.rocket.scripting.globals.interfaces.entity

import dev.znci.rocket.scripting.globals.tables.LuaLocation
import dev.znci.rocket.scripting.globals.tables.LuaLocation.Companion.toLua
import dev.znci.rocket.scripting.globals.tables.LuaVector3
import dev.znci.rocket.scripting.globals.tables.LuaVector3.Companion.toLua
import dev.znci.twine.annotations.TwineNativeFunction
import dev.znci.twine.annotations.TwineNativeProperty
import dev.znci.twine.annotations.TwineOverload
import io.papermc.paper.entity.LookAnchor
import org.bukkit.entity.Entity

@Suppress("unused")
interface Entity<T> where T : Entity {
    val entity: T

    @TwineNativeProperty
    val location: LuaLocation
        get() = entity.location.toLua()

    @TwineNativeProperty
    var velocity: LuaVector3
        get() = entity.velocity.toLua()
        set(value) { entity.setVelocity(value.toJava()) }

    @TwineNativeProperty
    val height: Double
        get() = entity.height

    @TwineNativeProperty
    val width: Double
        get() = entity.width

    // TODO: Wait for implementation
//    @TwineNativeProperty
//    val boundingBox: LuaBoundingBox

    @TwineNativeProperty
    val onGround: Boolean
        get() = entity.isOnGround

    @TwineNativeProperty
    val inWater: Boolean
        get() = entity.isInWater

    // TODO: Wait for implementation
//    @TwineNativeProperty
//    val world: LuaWorld

    @TwineNativeProperty
    val inWorld: Boolean
        get() = entity.isInWorld

    // TODO: Figure out what to do with this setter function
    // Maybe a Vector2 or a Rotation
    @TwineNativeFunction
    fun setRotation(yaw: Float, pitch: Float) {
        entity.setRotation(yaw, pitch)
    }

    @TwineNativeFunction
    fun teleport(location: LuaLocation) {
        entity.teleport(location.toJava())
    }

    // TODO: Implement LookAnchor!!
    @TwineOverload
    @TwineNativeFunction
    fun lookAt(x: Double, y: Double, z: Double) {
        entity.lookAt(x, y, z, LookAnchor.EYES)
    }

    @TwineOverload
    @TwineNativeFunction
    fun lookAt(vector: LuaVector3) {
        val bukkitVector = vector.toJava()
        entity.lookAt(bukkitVector.x, bukkitVector.y, bukkitVector.z, LookAnchor.EYES)
    }

    @TwineNativeProperty
    val entityId: Int
        get() = entity.entityId

    @TwineNativeProperty
    var fireTicks: Int
        get() = entity.fireTicks
        set(value) { entity.fireTicks = value }

    @TwineNativeProperty
    val maxFireTicks: Int
        get() = entity.maxFireTicks

    @TwineNativeProperty
    var visualFire: Boolean
        get() = entity.isVisualFire
        set(value) { entity.isVisualFire = value }

    @TwineNativeProperty
    var freezeTicks: Int
        get() = entity.freezeTicks
        set(value) { entity.freezeTicks = value }

    @TwineNativeProperty
    val maxFreezeTicks: Int
        get() = entity.maxFreezeTicks

    @TwineNativeProperty
    val frozen: Boolean
        get() = entity.isFrozen

    @TwineNativeProperty
    var invisible: Boolean
        get() = entity.isInvisible
        set(value) { entity.isInvisible = value }

    // noPhysics property is strange, surely it would make more sense to be physics
    // boolean hasNoPhysics();
    @TwineNativeProperty
    var physics: Boolean
        get() = !entity.hasNoPhysics()
        set(value) { entity.setNoPhysics(!value) }

    @TwineNativeProperty
    var freezeTickingLocked: Boolean
        get() = entity.isFreezeTickingLocked
        set(value) { entity.lockFreezeTicks(value) }

    @TwineNativeFunction
    fun remove() {
        entity.remove()
    }

    @TwineNativeProperty
    val dead: Boolean
        get() = entity.isDead

    @TwineNativeProperty
    val valid: Boolean
        get() = entity.isValid

    @TwineNativeProperty
    var persistent: Boolean
        get() = entity.isPersistent
        set(value) { entity.isPersistent = value }

    // TODO: Implement passengers

    @TwineNativeProperty
    val isEmpty: Boolean
        get() = entity.isEmpty

    @TwineNativeFunction
    fun ejectPassengers() {
        entity.eject()
    }

    @TwineNativeProperty
    var fallDistance: Float
        get() = entity.fallDistance
        set(value) { entity.fallDistance = value }

    // TODO: Implement EntityDamageEvent

    @TwineNativeProperty
    val uuid: String
        get() = entity.uniqueId.toString()

    @TwineNativeProperty
    var ticksLived: Int
        get() = entity.ticksLived
        set(value) { entity.ticksLived = value }

    // TODO: Implement EntityEffect

    // TODO: Implement EntityType

    // TODO: Implement Sound

    @TwineNativeProperty
    val inVehicle: Boolean
        get() = entity.isInsideVehicle

    @TwineNativeFunction
    fun leaveVehicle() {
        entity.leaveVehicle()
    }

    @TwineNativeProperty
    val vehicle: dev.znci.rocket.scripting.globals.interfaces.entity.Entity<T>?
        get() = entity.vehicle as? dev.znci.rocket.scripting.globals.interfaces.entity.Entity<T>

    @TwineNativeProperty
    var nameTagVisible: Boolean
        get() = entity.isCustomNameVisible
        set(value) { entity.isCustomNameVisible = value }

    @TwineNativeProperty
    var visibleByDefault: Boolean
        get() = entity.isVisibleByDefault
        set(value) { entity.isVisibleByDefault = value }

    // TODO: Implement @NotNull Set<Player> getTrackedBy();

    @TwineNativeProperty
    var glowing: Boolean
        get() = entity.isGlowing
        set(value) { entity.isGlowing = value }

    @TwineNativeProperty
    var invulnerable: Boolean
        get() = entity.isInvulnerable
        set(value) { entity.isInvulnerable = value }

    @TwineNativeProperty
    var silent: Boolean
        get() = entity.isSilent
        set(value) { entity.isSilent = value }

    @TwineNativeProperty
    var gravityEnabled: Boolean
        get() = entity.hasGravity()
        set(value) { entity.setGravity(value) }

    @TwineNativeProperty
    var portalCooldown: Int
        get() = entity.portalCooldown
        set(value) { entity.portalCooldown = value }

    @TwineNativeProperty
    val scoreboardTags: Set<String>
        get() = entity.scoreboardTags

    @TwineNativeFunction
    fun addScoreboardTag(tag: String) {
        entity.addScoreboardTag(tag)
    }

    @TwineNativeFunction
    fun removeScoreboardTag(tag: String) {
        entity.removeScoreboardTag(tag)
    }

    // TODO: Implement PistonMoveReaction

    // TODO: Implement BlockFace

    // TODO: Implement Pose

    @TwineNativeProperty
    val fixedPose: Boolean
        get() = entity.hasFixedPose()

    @TwineNativeProperty
    var sneaking: Boolean
        get() = entity.isSneaking
        set(value) { entity.isSneaking = value }

    // TODO: Implement SpawnCategory

    @TwineNativeProperty
    val nbtString: String
        get() = entity.asString.toString()

    // TODO: Implement EntitySnapshot

    @TwineNativeFunction
    fun copy(): dev.znci.rocket.scripting.globals.interfaces.entity.Entity<T> {
        return entity.copy() as dev.znci.rocket.scripting.globals.interfaces.entity.Entity<T>
    }

    // TODO: Implement Component

    @TwineNativeProperty
    val origin: LuaLocation
        get() = entity.origin!!.toLua()

    @TwineNativeProperty
    val fromSpawner: Boolean
        get() = entity.fromMobSpawner()

    // TODO: Implement Chunk

    // TODO: Implement SpawnReason

    @TwineNativeProperty
    val underWater: Boolean
        get() = entity.isUnderWater

    @TwineNativeProperty
    val inRain: Boolean
        get() = entity.isInRain

    // ! Deprecated in 1.21.5
    @TwineNativeProperty
    val inBubbleColumn: Boolean
        get() = entity.isInBubbleColumn

    @TwineNativeProperty
    val inWaterOrRain: Boolean
        get() = entity.isInWaterOrRain

    @TwineNativeProperty
    val inWaterOrBubbleColumn: Boolean
        get() = entity.isInWaterOrBubbleColumn

    @TwineNativeProperty
    val inWaterOrRainOrBubbleColumn: Boolean
        get() = entity.isInWaterOrRainOrBubbleColumn

    @TwineNativeProperty
    val inLava: Boolean
        get() = entity.isInLava

    @TwineNativeProperty
    val ticking: Boolean
        get() = entity.isTicking

    @TwineNativeFunction
    fun spawnAt(location: LuaLocation) {
        entity.spawnAt(location.toJava())
    }

    @TwineNativeProperty
    val inPoweredSnow: Boolean
        get() = entity.isInPowderedSnow

    @TwineNativeFunction
    fun doesCollideAt(location: LuaLocation): Boolean {
        return entity.collidesAt(location.toJava())
    }
    
    // TODO: Implement BoundingBox

    // TODO: Implement EntityScheduler

    @TwineNativeProperty
    val scoreboardName: String
        get() = entity.scoreboardEntryName
}