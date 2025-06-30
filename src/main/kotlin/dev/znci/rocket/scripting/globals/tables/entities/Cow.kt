package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAnimalEntity
import org.bukkit.entity.Cow
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.COW)
class Cow(entity: Cow):
    BaseAnimalEntity<Cow>(entity)
