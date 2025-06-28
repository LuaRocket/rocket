package dev.znci.rocket.scripting.globals.tables

import dev.znci.rocket.scripting.annotations.Global
import dev.znci.rocket.scripting.api.RocketError
import dev.znci.rocket.scripting.globals.enums.LuaMaterial
import dev.znci.rocket.util.MessageFormatter
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeFunction
import dev.znci.twine.annotations.TwineNativeProperty
import dev.znci.twine.nativex.TwineNative
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

@Suppress("unused")
@Global
class LuaItems : TwineNative("item") {
    @TwineNativeFunction
    fun new(item: TwineEnumValue): LuaItem {
        return LuaItem(item)
    }
}

@Suppress("unused")
class LuaItem(
    itemEnum: TwineEnumValue,
) : TwineNative() {
    private val itemName: String = itemEnum.name
    private val itemType: Material = Material.matchMaterial(itemName)
        ?: throw RocketError("Invalid item type: $itemName")
    private val itemStack: ItemStack = ItemStack(itemType, 1)

    @TwineNativeProperty("itemEnum")
    val itemEnum: TwineEnumValue
        get() = LuaMaterial().getValue(itemType.ordinal)

    @TwineNativeProperty
    var name: String
        get() = itemStack.itemMeta?.displayName()?.toString() ?: itemName
        set(value) {
            val messageComponent = MessageFormatter.formatMessage(value.toString())
            val meta = itemStack.itemMeta ?: return
            meta.displayName(messageComponent)
            val success = itemStack.setItemMeta(meta)
            println("Setting item name to: $value with success=$success and meta: ${itemStack.itemMeta?.displayName()}")
        }

    companion object {
        fun ItemStack.toLua(): LuaItem {
            val itemType = this.type
            val itemEnumValue = LuaMaterial().getValue(itemType.ordinal)
            return LuaItem(itemEnumValue)
        }
    }

    fun toJava(): ItemStack {
        val itemMeta = itemStack.itemMeta
//        itemMeta.displayName(MessageFormatter.formatMessage(meta.displayName))
        itemStack.itemMeta = itemMeta

        println("toJava: meta displayName = ${itemStack.itemMeta?.displayName()}")
        return itemStack.clone()
    }
}