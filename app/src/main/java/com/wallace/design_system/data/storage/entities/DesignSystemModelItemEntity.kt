package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_MODEL_ITEM_TABLE

@Entity(tableName = DESIGN_SYSTEM_MODEL_ITEM_TABLE)
data class DesignSystemModelItemEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long? = null,
    var category: String? = null,
    var dsTokens: List<DesignSystemDsTokenEntity>? = listOf()
)
