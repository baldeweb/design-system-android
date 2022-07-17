package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY_BASE
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_FAMILY_HIGHLIGHT
import com.wallace.design_system.data.utils.convertToObject

class DSFontFamilyDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey) {
    suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    internal suspend fun getFontFamilyBase() = getContent().find { it.name == DS_FONT_FAMILY_BASE }
    internal suspend fun getFontFamilyHighlight() = getContent().find { it.name == DS_FONT_FAMILY_HIGHLIGHT }
}