package com.wallace.design_system.data.storage.room

import androidx.lifecycle.LiveData
import androidx.room.*
import com.wallace.design_system.data.storage.entities.DesignSystemDataEntity
import com.wallace.design_system.data.storage.entities.DesignSystemEntity

@Dao
interface DesignSystemDAO: BaseDAO<DesignSystemEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDesignSystem(data: DesignSystemEntity)

    @Transaction
    @Query("SELECT * FROM design_system_data_table WHERE category LIKE :categoryName")
    fun getDesignSystem(categoryName: String) : LiveData<List<DesignSystemDataEntity>>

    @Update
    fun updateDesignSystem(data: DesignSystemEntity)

    @Delete
    override fun delete(data: DesignSystemEntity)
}