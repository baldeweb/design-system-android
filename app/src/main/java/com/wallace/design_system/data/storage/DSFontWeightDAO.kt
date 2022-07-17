package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.google.gson.Gson
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSFontConstants
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_BLACK
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_BOLD
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_LIGHT
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_MEDIUM
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_WEIGHT_REGULAR
import com.wallace.design_system.data.utils.convertToObject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DSFontWeightDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey) {
    suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    internal suspend fun getFontWeightBlack() = getContent().find { it.name == DS_FONT_WEIGHT_BLACK }
    internal suspend fun getFontWeightBold() = getContent().find { it.name == DS_FONT_WEIGHT_BOLD }
    internal suspend fun getFontWeightMedium() = getContent().find { it.name == DS_FONT_WEIGHT_MEDIUM }
    internal suspend fun getFontWeightRegular() = getContent().find { it.name == DS_FONT_WEIGHT_REGULAR }
    internal suspend fun getFontWeightLight() = getContent().find { it.name == DS_FONT_WEIGHT_LIGHT }
}