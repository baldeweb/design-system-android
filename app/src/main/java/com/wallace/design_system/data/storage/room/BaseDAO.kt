package com.wallace.design_system.data.storage.room

interface BaseDAO<T> {
    companion object {
        const val DESIGN_SYSTEM_TABLE = "design_system_table"
        const val DESIGN_SYSTEM_DATA_TABLE = "design_system_data_table"
        const val DESIGN_SYSTEM_MODEL_ITEM_TABLE = "design_system_model_item_table"
        const val DESIGN_SYSTEM_DS_TOKEN_TABLE = "design_system_ds_token_table"
        const val DESIGN_SYSTEM_VALUE_TABLE = "design_system_value_table"
    }

    fun insert(data: T)
    fun getDataList(): List<T>
    fun getData(): T
    fun updateData(newData: T)
    fun delete(data: T)
}