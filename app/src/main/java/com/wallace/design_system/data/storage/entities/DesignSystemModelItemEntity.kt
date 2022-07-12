package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "design_system_model_item_table")
data class DesignSystemModelItemEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long? = null,
    var category: String? = null,
    var dsTokens: List<DesignSystemDsTokenEntity>? = listOf()
)
