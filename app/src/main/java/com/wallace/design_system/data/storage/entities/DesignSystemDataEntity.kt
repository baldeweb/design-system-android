package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "design_system_data_table")
data class DesignSystemDataEntity(
    @PrimaryKey(autoGenerate = false)
    @NonNull
    var id: Long? = null,
    var items: List<DesignSystemModelItemEntity>? = listOf()
)
