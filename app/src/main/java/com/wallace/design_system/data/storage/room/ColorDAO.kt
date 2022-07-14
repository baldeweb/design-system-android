package com.wallace.design_system.data.storage.room

import androidx.room.*
import com.wallace.design_system.data.storage.entities.DesignSystemDataEntity
import com.wallace.design_system.data.storage.entities.DesignSystemDsTokenEntity
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_DATA_TABLE

@Dao
interface ColorDAO: BaseDAO<DesignSystemDataEntity> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override fun insert(data: DesignSystemDataEntity)

    @Transaction
    @Query("SELECT * FROM $DESIGN_SYSTEM_DATA_TABLE WHERE category LIKE 'color'")
    override fun getData(): DesignSystemDataEntity

    @Update
    override fun updateData(newData: DesignSystemDataEntity)

    @Delete
    override fun delete(data: DesignSystemDataEntity)
}