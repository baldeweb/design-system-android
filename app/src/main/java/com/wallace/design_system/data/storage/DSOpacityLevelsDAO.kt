package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.preferences.core.Preferences
import com.google.gson.Gson
import com.wallace.design_system.data.model.DesignSystemModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DSOpacityLevelsDAO(
    context: Context, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, prefsKey) {
    suspend fun getDataConverted(): DesignSystemModel.Data? {
        return Gson().fromJson(getData().first(), DesignSystemModel.Data::class.java)
    }
}