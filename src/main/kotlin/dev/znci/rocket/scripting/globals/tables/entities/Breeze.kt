package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseMonsterEntity
import org.bukkit.entity.Breeze
import org.bukkit.entity.EntityType

@Suppress("unused")
@Entity(EntityType.BREEZE)
class Breeze(entity: Breeze):
    BaseMonsterEntity<Breeze>(entity)