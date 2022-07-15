package com.wallace.design_system.data.storage.room

import androidx.room.*
import com.wallace.design_system.data.storage.entities.DesignSystemEntity

@Dao
interface DesignSystemDAO: BaseDAO<DesignSystemEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insert(data: DesignSystemEntity)

    @Transaction
    @Query("SELECT * FROM design_system_data_table")
    override fun getData() : DesignSystemEntity

    @Update
    override fun updateData(newData: DesignSystemEntity)

    @Delete
    override fun delete(data: DesignSystemEntity)
}