package com.wallace.design_system.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "design_system_table")
data class DesignSystemEntity(
    @PrimaryKey(autoGenerate = false)
    var version: Long? = null,
    var data: List<DesignSystemDataEntity>? = listOf()
)
