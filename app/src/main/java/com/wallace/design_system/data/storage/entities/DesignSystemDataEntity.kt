package com.wallace.design_system.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_DATA_TABLE

@Entity(tableName = DESIGN_SYSTEM_DATA_TABLE)
data class DesignSystemDataEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var category: String? = null,
    var dsTokens: List<DesignSystemDsTokenEntity>? = null
)
