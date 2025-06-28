package dev.znci.rocket.scripting.globals.tables.entities

import dev.znci.rocket.scripting.annotations.Entity
import dev.znci.rocket.scripting.globals.interfaces.entity.BaseBoatEntity
import org.bukkit.entity.EntityType
import org.bukkit.entity.boat.AcaciaBoat
import org.bukkit.entity.boat.BambooRaft
import org.bukkit.entity.boat.BirchBoat
import org.bukkit.entity.boat.CherryBoat
import org.bukkit.entity.boat.DarkOakBoat
import org.bukkit.entity.boat.JungleBoat
import org.bukkit.entity.boat.MangroveBoat
import org.bukkit.entity.boat.OakBoat
import org.bukkit.entity.boat.PaleOakBoat
import org.bukkit.entity.boat.SpruceBoat

@Suppress("unused")
@Entity(EntityType.ACACIA_BOAT)
class AcaciaBoat(entity: AcaciaBoat):
    BaseBoatEntity<AcaciaBoat>(entity)

@Suppress("unused")
@Entity(EntityType.BAMBOO_RAFT)
class BambooRaft(entity: BambooRaft):
    BaseBoatEntity<BambooRaft>(entity)

@Suppress("unused")
@Entity(EntityType.BIRCH_BOAT)
class BirchBoat(entity: BirchBoat):
    BaseBoatEntity<BirchBoat>(entity)

@Suppress("unused")
@Entity(EntityType.CHERRY_BOAT)
class CherryBoat(entity: CherryBoat):
    BaseBoatEntity<CherryBoat>(entity)

@Suppress("unused")
@Entity(EntityType.DARK_OAK_BOAT)
class DarkOakBoat(entity: DarkOakBoat):
    BaseBoatEntity<DarkOakBoat>(entity)

@Suppress("unused")
@Entity(EntityType.JUNGLE_BOAT)
class JungleBoat(entity: JungleBoat):
    BaseBoatEntity<JungleBoat>(entity)

@Suppress("unused")
@Entity(EntityType.MANGROVE_BOAT)
class MangroveBoat(entity: MangroveBoat):
    BaseBoatEntity<MangroveBoat>(entity)

@Suppress("unused")
@Entity(EntityType.OAK_BOAT)
class OakBoat(entity: OakBoat):
    BaseBoatEntity<OakBoat>(entity)

@Suppress("unused")
@Entity(EntityType.PALE_OAK_BOAT)
class PaleOakBoat(entity: PaleOakBoat):
    BaseBoatEntity<PaleOakBoat>(entity)

@Suppress("unused")
@Entity(EntityType.SPRUCE_BOAT)
class SpruceBoat(entity: SpruceBoat):
    BaseBoatEntity<SpruceBoat>(entity)
