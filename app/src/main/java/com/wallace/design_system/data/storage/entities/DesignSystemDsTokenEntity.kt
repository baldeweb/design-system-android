package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_DS_TOKEN_TABLE

@Entity(tableName = DESIGN_SYSTEM_DS_TOKEN_TABLE)
data class DesignSystemDsTokenEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long? = null,
    var name: String? = null,
    var type: String? = null,
    var values: List<DesignSystemValueEntity>? = listOf()
)
