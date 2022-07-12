package com.wallace.design_system.data.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wallace.design_system.data.storage.entities.*
import com.wallace.design_system.data.utils.Converters

@Database(
    entities = [
        DesignSystemEntity::class,
        DesignSystemDataEntity::class,
        DesignSystemModelItemEntity::class,
        DesignSystemDsTokenEntity::class,
        DesignSystemValueEntity::class,
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(Converters::class)
abstract class BaseDatabase: RoomDatabase() {
    abstract fun designSystemDAO(): DesignSystemDAO
}