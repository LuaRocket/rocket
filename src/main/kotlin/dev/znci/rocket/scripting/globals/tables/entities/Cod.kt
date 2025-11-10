package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseFishEntity
import org.bukkit.entity.Cod
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.COD)
class Cod(entity: Cod):
    BaseFishEntity<Cod>(entity)