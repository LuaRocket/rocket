/**
 * Copyright 2025 znci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.znci.rocket.scripting

import dev.znci.rocket.scripting.classes.CommandReference
import dev.znci.twine.TwineEnum
import dev.znci.twine.TwineLuaValue
import dev.znci.twine.TwineProperty
import dev.znci.twine.TwineTable
import dev.znci.twine.nativex.conversion.Converter.toLuaValue
import org.bukkit.event.Event
import org.luaj.vm2.Globals
import org.luaj.vm2.LuaError
import org.luaj.vm2.LuaTable
import org.luaj.vm2.LuaValue
import org.luaj.vm2.lib.jse.JsePlatform
import java.io.File

/**
 * The `ScriptManager` object is responsible for managing Lua scripts, global values, and event handling in the plugin.
 * It allows for the loading and running of scripts, registering and unregistering global values.
 */
object ScriptManager {
    /**
     * The global environment for Lua scripts.
     * This is used to load and execute Lua code with a standard Lua environment.
     */
    private val globals: Globals = JsePlatform.standardGlobals()

    /**
     * The folder where scripts are located.
     * This can be set to a custom folder to load Lua scripts from a specific directory.
     */
    var scriptsFolder: File = File("")

    /**
     * A map of events and their associated Lua handlers.
     * It stores the events triggered in the system and the corresponding Lua functions that handle them.
     */
    val usedEvents = mutableMapOf<Class<out Event>, LuaValue>()

    /**
     * A map of enabled commands by their names.
     * It associates command names with their respective command executors.
     */
    @Suppress("unused")
    val enabledCommands = mutableMapOf<String, CommandReference>()

    /**
     * Sets the folder where scripts are located.
     *
     * @param folder The folder containing the Lua scripts.
     */
    @Suppress("unused") // TODO: Will be used in the future when custom configuration folders are implemented
    fun setFolder(folder: File) {
        scriptsFolder = folder
    }

    /**
     * Loads all scripts from the `scriptsFolder` directory.
     * This method currently prints the content of the scripts, but is planned for future use when custom folder configurations are implemented.
     */
    @Suppress("unused") // TODO: Is this still required?
    fun loadScripts() {
        scriptsFolder.walkTopDown().forEach { file ->
            if (file.isFile && !file.startsWith("-")) {
                val content = file.readText()
                runScript(content)
            }
        }
    }

    /**
     * Retrieves a list of all scripts available in the `scriptsFolder` directory.
     * Optionally, can include or exclude disabled scripts based on their file name (files starting with "-").
     *
     * @param includeDisabled If `true`, disabled scripts (starting with '-') are included.
     * @return A list of script file paths relative to the plugin directory.
     */
    fun getAllScripts(includeDisabled: Boolean = true): List<String> {
        val list = ArrayList<String>()
        scriptsFolder.walkTopDown().forEach { file ->
            if (file.isFile) {
                if (includeDisabled && file.startsWith("-")) return@forEach
                list.add(file.path.removePrefix("plugins/rocket/scripts/").removePrefix("plugins\\rocket\\scripts\\"))
            }
        }
        return list
    }

    /**
     * Runs a Lua script provided as a string.
     * The script is executed within the global Lua environment, and any errors are caught and returned as a string message.
     *
     * @param text The Lua script content to execute.
     * @return An error message if execution fails, or an empty string if the script ran successfully.
     */
    fun runScript(text: String): String? {
        try {
            applyGlobals()
            val scriptResult = globals.load(text, "script", globals)

            scriptResult.call()
        } catch (e: LuaError) {
            e.printStackTrace()
            return e.message
        }

        return ""
    }

    /**
     * Applies the registered global values to the Lua environment.
     * This makes all registered globals available to Lua scripts.
     */
    private fun applyGlobals() {
        GlobalRegistry.enabledGlobals.forEach { (_, global) ->
            when (global) {
                is TwineEnum -> {
                    global.table = global.toLuaTable()
                    global.table = global.toLuaValue() as LuaTable

                    globals.set(global.valueName, global.table)
                }
                is TwineTable -> {
                    val table = global.toLuaValue()
                    globals.set(global.valueName, table)
                }
                is TwineProperty -> {
                    globals.set(global.valueName, TwineLuaValue.valueOf(global.value))
                }
            }
        }
    }
}