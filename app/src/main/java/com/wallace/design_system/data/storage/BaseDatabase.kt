package com.wallace.design_system.data.storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
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
    version = 1
)
@TypeConverters(Converters::class)
abstract class BaseDatabase: RoomDatabase() {
    abstract fun designSystemDAO(): DesignSystemDAO

    companion object {
        private var instance: BaseDatabase? = null
        @Synchronized
        fun getInstance(ctx: Context): BaseDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    BaseDatabase::class.java,
                    "database-designsystem"
                ).build()
            }
            return instance
        }
    }
}