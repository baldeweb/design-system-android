package com.wallace.design_system.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_TABLE

@Entity(tableName = DESIGN_SYSTEM_TABLE)
data class DesignSystemEntity(
    @PrimaryKey(autoGenerate = false)
    var version: Long? = null,
    var data: List<DesignSystemDataEntity>? = listOf()
)
