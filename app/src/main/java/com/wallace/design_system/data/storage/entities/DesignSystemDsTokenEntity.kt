package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.model.DesignSystemModel

@Entity(tableName = "design_system_ds_token_table")
data class DesignSystemDsTokenEntity(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    var id: Long? = null,
    var name: String? = null,
    var type: String? = null,
    var values: List<DesignSystemValueEntity>? = listOf()
)
