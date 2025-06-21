package dev.znci.rocket.scripting

import dev.znci.rocket.scripting.api.RocketError
import dev.znci.twine.TwineValueBase
import kotlin.collections.set

object GlobalRegistry {
    /**
     * A list of global values (properties and tables) that have been registered for Lua scripting.
     * These globals are made available to Lua scripts during their execution.
     */
    var enabledGlobals: MutableMap<String, TwineValueBase> = mutableMapOf()

    /**
     * Retrieves a global value by its table name.
     *
     * @param valueName The name of the global value to retrieve.
     * @return The global value if found, or `null` if it is not registered.
     */
    private fun getGlobalByTableName(valueName: String): TwineValueBase? {
        return enabledGlobals[valueName]
    }

    /**
     * Shorthand for getGlobalByTableName
     */
    fun get(valueName: String): TwineValueBase? {
        return getGlobalByTableName(valueName)
    }

    /**
     * Registers a global value, making it available for use in Lua.
     *
     * @param global The global value to register.
     * @throws RocketError If a global with the same table name is already registered.
     */
    fun registerGlobal(global: TwineValueBase) {
        if (enabledGlobals.containsKey(global.valueName)) {
            throw RocketError("A global of the same table name ('${global.valueName}') is already registered.")
        }

        if (global.valueName.isEmpty()) {
            throw RocketError("Global table name cannot be empty.")
        }

        enabledGlobals[global.valueName] = global
    }

    /**
     * Unregisters a global value, making it unavailable for use in Lua.
     *
     * @param global The global value to unregister.
     * @throws RocketError If no global with the given table name is registered.
     */

    @Suppress("unused")
    fun unregisterGlobal(global: TwineValueBase) {
        if (!enabledGlobals.containsKey(global.valueName)) {
            throw RocketError("A global with the table name ('${global.valueName}') is not registered and cannot be unregistered.")
        }

        enabledGlobals.remove(global.valueName)
    }
}