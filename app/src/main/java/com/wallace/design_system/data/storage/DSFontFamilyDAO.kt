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
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): List<DesignSystemModel.Value>? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getFontFamilyBase() = getContent().find {
        it.name == DS_FONT_FAMILY_BASE
    }?.values?.first()?.value ?: ""

    internal suspend fun getFontFamilyHighlight() = getContent().find {
        it.name == DS_FONT_FAMILY_HIGHLIGHT
    }?.values?.first()?.value ?: ""
}