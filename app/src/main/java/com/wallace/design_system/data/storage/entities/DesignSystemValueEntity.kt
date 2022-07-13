package com.wallace.design_system.data.storage.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_VALUE_TABLE

@Entity(tableName = DESIGN_SYSTEM_VALUE_TABLE)
data class DesignSystemValueEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null,
    var alpha: Double? = null,
    var reference: String? = null,
    var value: String? = null,
    var weight: Double? = null
)
