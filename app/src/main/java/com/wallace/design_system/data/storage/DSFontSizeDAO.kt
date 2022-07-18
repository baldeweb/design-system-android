package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSFontConstants
import com.wallace.design_system.data.utils.convertToObject

class DSFontSizeDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey) {

    private suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    internal suspend fun getFontSizeXXXS() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_XXXS
    }
    internal suspend fun getFontSizeXXS() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_XXS
    }
    internal suspend fun getFontSizeXS() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_XS
    }
    internal suspend fun getFontSizeSM() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_SM
    }
    internal suspend fun getFontSizeMD() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_MD
    }
    internal suspend fun getFontSizeLG() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_LG
    }
    internal suspend fun getFontSizeXL() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_XL
    }
    internal suspend fun getFontSizeXXL() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_XXL
    }
    internal suspend fun getFontSizeXXXL() = getContent().find {
        it.name == DSFontConstants.DS_FONT_SIZE_XXXL
    }
}