package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseDisplayEntity
import dev.znci.rocket.scripting.globals.tables.LuaColor
import dev.znci.rocket.scripting.globals.tables.LuaColor.Companion.toLua
import dev.znci.rocket.util.MessageFormatter
import dev.znci.twine.TwineEnum.Companion.toLua
import dev.znci.twine.TwineEnumValue
import dev.znci.twine.annotations.TwineNativeProperty
import org.bukkit.entity.EntityType
import org.bukkit.entity.TextDisplay

@Entity(EntityType.TEXT_DISPLAY)
@Suppress("unused")
class LuaTextDisplayEntity(entity: TextDisplay): BaseDisplayEntity<TextDisplay>(entity) {
    @TwineNativeProperty
    var text: String
        get() = entity.text().toString()
        set(value) {
            val messageComponent = MessageFormatter.formatMessage(value.toString())
            entity.text(messageComponent)
        }

    @TwineNativeProperty
    var lineWidth: Int
        get() = entity.lineWidth
        set(value) { entity.lineWidth = value }

    @TwineNativeProperty
    var backgroundColor: LuaColor
        get() = entity.backgroundColor!!.toLua()
        set(value) { entity.backgroundColor = value.toJava() }

    @TwineNativeProperty
    var textOpacity: Double
        get() = entity.textOpacity.toDouble()
        set(value) { entity.textOpacity = value.toInt().toByte() }

    @TwineNativeProperty
    var shadowed: Boolean
        get() = entity.isShadowed
        set(value) { entity.isShadowed = value }

    @TwineNativeProperty
    var seeThrough: Boolean
        get() = entity.isSeeThrough
        set(value) { entity.isSeeThrough = value }

    @TwineNativeProperty
    var alignment: TwineEnumValue
        get() {
            return entity.alignment.toLua()
        }
        set(value) {
            entity.alignment = value.toJava() as TextDisplay.TextAlignment
        }
}