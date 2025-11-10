package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseSpiderEntity
import org.bukkit.entity.CaveSpider
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.CAVE_SPIDER)
class CaveSpider(entity: CaveSpider):
    BaseSpiderEntity<CaveSpider>(entity)