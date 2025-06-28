package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseAnimalEntity
import org.bukkit.entity.Armadillo
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.ARMADILLO)
class Armadillo(entity: Armadillo):
    BaseAnimalEntity<Armadillo>(entity)