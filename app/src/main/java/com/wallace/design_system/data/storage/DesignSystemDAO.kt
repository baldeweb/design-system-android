package com.wallace.design_system.data.storage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.wallace.design_system.data.storage.entities.DesignSystemDataEntity
import com.wallace.design_system.data.storage.entities.DesignSystemEntity
import com.wallace.design_system.data.storage.entities.DesignSystemModelItemEntity

@Dao
interface DesignSystemDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDesignSystem(user: DesignSystemModelItemEntity)

    @Transaction
    @Query("SELECT * FROM design_system_table")
    fun getDesignSystem() : LiveData<List<DesignSystemEntity>>

    @Transaction
    @Query("SELECT * FROM design_system_data_table")
    fun getDesignSystemData() : LiveData<List<DesignSystemDataEntity>>

    @Update
    fun updateUserDetails(user: DesignSystemModelItemEntity)

    @Delete
    fun delete(user: DesignSystemModelItemEntity)
}