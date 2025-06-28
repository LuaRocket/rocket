package dev.znci.rocket.scripting.globals.tables

import dev.znci.rocket.Rocket
import dev.znci.rocket.scripting.annotations.Global
import dev.znci.twine.annotations.TwineNativeFunction
import dev.znci.twine.nativex.TwineNative
import org.bukkit.scheduler.BukkitRunnable

@Suppress("unused")
@Global
class LuaScheduler : TwineNative("scheduler") {
    val intervals: MutableList<LuaIntervalSchedule> = mutableListOf()

    @TwineNativeFunction
    fun runLater(ticks: Long, callback: () -> Unit) {
        object : BukkitRunnable() {
            override fun run() {
                callback()
            }
        }.runTaskLater(
            Rocket.instance, ticks
        )
    }

    @TwineNativeFunction
    fun runTask(callback: () -> Unit) {
        object : BukkitRunnable() {
            override fun run() {
                callback()
            }
        }.runTask(
            Rocket.instance
        )
    }

    @TwineNativeFunction
    fun runInterval(ticks: Long, callback: (schedule: LuaIntervalSchedule) -> Unit): LuaIntervalSchedule {
        val schedule = LuaIntervalSchedule(ticks, callback, this)
        intervals.add(schedule)
        schedule.start()
        return schedule
    }

    @TwineNativeFunction
    fun stopInterval(schedule: LuaIntervalSchedule) {
        schedule.stop()
        intervals.remove(schedule)
    }

    @TwineNativeFunction
    fun stopAllIntervals() {
        intervals.forEach { it.stop() }
        intervals.clear()
    }

    fun removeInterval(schedule: LuaIntervalSchedule) {
        intervals.remove(schedule)
    }
}

@Suppress("unused")
class LuaIntervalSchedule(
    private val ticks: Long,
    private val callback: (schedule: LuaIntervalSchedule) -> Unit,
    private val scheduler: LuaScheduler
) : TwineNative() {
    @Volatile
    private var isRunning = false
    private var runnable: BukkitRunnable? = null

    @TwineNativeFunction
    fun start() {
        isRunning = true
        val task = object : BukkitRunnable() {
            override fun run() {
                if (!isRunning) {
                    cancel()
                    return
                }
                try {
                    callback(this@LuaIntervalSchedule)
                } catch (e: Exception) {
                    e.printStackTrace()
                    cancel()
                    isRunning = false
                    scheduler.removeInterval(this@LuaIntervalSchedule)
                }
            }
        }
        runnable = task
        task.runTaskTimer(Rocket.instance, 0L, ticks)
    }

    @TwineNativeFunction
    fun stop() {
        isRunning = false
        runnable?.cancel()
        runnable = null
        scheduler.removeInterval(this)
    }
}