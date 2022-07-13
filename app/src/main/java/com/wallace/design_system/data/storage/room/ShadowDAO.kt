package com.wallace.design_system.data.storage.room

import androidx.room.*
import com.wallace.design_system.data.storage.entities.DesignSystemDsTokenEntity
import com.wallace.design_system.data.storage.room.BaseDAO.Companion.DESIGN_SYSTEM_MODEL_ITEM_TABLE

@Dao
interface ShadowDAO: BaseDAO<DesignSystemDsTokenEntity> {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    override fun insert(data: DesignSystemDsTokenEntity)

    @Transaction
    @Query("SELECT * FROM $DESIGN_SYSTEM_MODEL_ITEM_TABLE WHERE category = 'shadow'")
    override fun getDataList(): List<DesignSystemDsTokenEntity>

    @Transaction
    @Query("SELECT * FROM $DESIGN_SYSTEM_MODEL_ITEM_TABLE WHERE category = 'shadow'")
    override fun getData(): DesignSystemDsTokenEntity

    @Update
    override fun updateData(newData: DesignSystemDsTokenEntity)

    @Delete
    override fun delete(data: DesignSystemDsTokenEntity)
}