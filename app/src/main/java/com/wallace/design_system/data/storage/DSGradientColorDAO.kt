package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.google.gson.Gson
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSColorConstants
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_HIGHLIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_PRIMARY
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_SECONDARY
import com.wallace.design_system.data.utils.convertToObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DSGradientColorDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey) {

    private suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    internal suspend fun getGradientColorPrimary() = getContent().find {
        it.name == DS_GRADIENT_COLOR_PRIMARY
    }
    internal suspend fun getGradientColorSecondary() = getContent().find {
        it.name == DS_GRADIENT_COLOR_SECONDARY
    }
    internal suspend fun getGradientColorHighlight() = getContent().find {
        it.name == DS_GRADIENT_COLOR_HIGHLIGHT
    }
}