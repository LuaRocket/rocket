package dev.znci.rocket.scripting.globals.interfaces.entity

import org.bukkit.entity.Vehicle

interface Vehicle<T> : Entity<T> where T: Vehicle
