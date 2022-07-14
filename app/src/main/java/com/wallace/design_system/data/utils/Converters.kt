package com.wallace.design_system.data.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wallace.design_system.data.storage.entities.*

class Converters {
    @TypeConverter
    fun listDataEntityToJson(value: List<DesignSystemDataEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToDataEntityList(value: String) = Gson().fromJson(value, Array<DesignSystemDataEntity>::class.java).toList()

    @TypeConverter
    fun listDsTokenEntityToJson(value: List<DesignSystemDsTokenEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToDsTokenEntityList(value: String) = Gson().fromJson(value, Array<DesignSystemDsTokenEntity>::class.java).toList()

    @TypeConverter
    fun listValueEntityToJson(value: List<DesignSystemValueEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToValueEntityList(value: String) = Gson().fromJson(value, Array<DesignSystemValueEntity>::class.java).toList()
}