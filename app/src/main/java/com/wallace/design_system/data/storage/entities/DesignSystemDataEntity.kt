package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_DATA_TABLE

@Entity(tableName = DESIGN_SYSTEM_DATA_TABLE)
data class DesignSystemDataEntity(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    var id: Long? = null,
    var items: List<DesignSystemModelItemEntity>? = listOf()
)
