package dev.znci.rocket.scripting.globals.tables

import dev.znci.rocket.scripting.EntityRegistry
import dev.znci.rocket.scripting.annotations.Global
import dev.znci.rocket.scripting.api.RocketError
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.nativex.TwineNative
import dev.znci.twine.annotations.TwineNativeFunction
import org.bukkit.entity.Entity
import org.bukkit.entity.EntityType
import kotlin.reflect.full.primaryConstructor

interface RocketEntity<out T : Entity> {
    val entity: T
}

@Suppress("unused")
@Global
class LuaEntities : TwineNative("entity") {
    @TwineNativeFunction
    fun new(entityType: TwineEnumValue): RocketEntity<*> {
        val luaValue = entityType.toJava()

        val world = org.bukkit.Bukkit.getWorlds().first()

        val bukkitType = EntityType.entries.find { it.name.equals(luaValue.toLua().name, ignoreCase = true) }
            ?: throw RocketError("Invalid entity type: $luaValue")
        val entityClass = bukkitType.entityClass ?: throw RocketError("Entity class not found for type: $entityType")
        val bukkitEntity = world.spawn(world.spawnLocation.add(0.0, 20.0, 0.0), entityClass)

        val wrapperClass = EntityRegistry.getWrapper(bukkitType.name)
            ?: throw RocketError("No Lua wrapper registered for entity type: $entityType")

        val constructor = wrapperClass.primaryConstructor
            ?: throw RocketError("Wrapper class ${wrapperClass.simpleName} has no primary constructor")

        return constructor.call(bukkitEntity)
    }
}
