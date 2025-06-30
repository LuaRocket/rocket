package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAbstractHorseEntity
import dev.znci.rocket.scripting.globals.interfaces.entity.Sittable
import org.bukkit.entity.Camel
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.CAMEL)
class Camel(entity: Camel):
    BaseAbstractHorseEntity<Camel>(entity),
    Sittable<Camel>