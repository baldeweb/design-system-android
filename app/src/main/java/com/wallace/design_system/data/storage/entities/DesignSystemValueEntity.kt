package com.wallace.design_system.data.storage.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.model.DesignSystemModel

@Entity(tableName = "design_system_value_table")
data class DesignSystemValueEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var alpha: Double? = null,
    var reference: String? = null,
    var value: String? = null,
    var weight: Double? = null
)
