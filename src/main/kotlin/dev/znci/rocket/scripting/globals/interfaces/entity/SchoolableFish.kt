package dev.znci.rocket.scripting.globals.interfaces.entity

import io.papermc.paper.entity.SchoolableFish

interface SchoolableFish<T> : Fish<T> where T: SchoolableFish {
    fun startFollowing(leader: SchoolableFish) {
        entity.startFollowing(leader)
    }
    fun stopFollowing() {
        entity.stopFollowing()
    }

    val schoolSize: Int
        get() = entity.schoolSize
    val maxSchoolSize: Int
        get() = entity.maxSchoolSize

    val schoolLeader: SchoolableFish?
        get() = entity.schoolLeader
}
