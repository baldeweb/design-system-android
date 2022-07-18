package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_LG
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_MD
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_SM
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XL
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XS
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXL
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXS
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXXL
import com.wallace.design_system.data.utils.DSFontConstants.DS_FONT_SIZE_XXXS
import com.wallace.design_system.data.utils.convertToObject

class DSFontSizeDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): DesignSystemModel.Value? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getFontSizeXXXS() = getContent().find {
        it.name == DS_FONT_SIZE_XXXS
    }?.values?.first()?.value?.toFloat() ?: 10F

    internal suspend fun getFontSizeXXS() = getContent().find {
        it.name == DS_FONT_SIZE_XXS
    }?.values?.first()?.value?.toFloat() ?: 12F

    internal suspend fun getFontSizeXS() = getContent().find {
        it.name == DS_FONT_SIZE_XS
    }?.values?.first()?.value?.toFloat() ?: 14F

    internal suspend fun getFontSizeSM() = getContent().find {
        it.name == DS_FONT_SIZE_SM
    }?.values?.first()?.value?.toFloat() ?: 16F

    internal suspend fun getFontSizeMD() = getContent().find {
        it.name == DS_FONT_SIZE_MD
    }?.values?.first()?.value?.toFloat() ?: 18F

    internal suspend fun getFontSizeLG() = getContent().find {
        it.name == DS_FONT_SIZE_LG
    }?.values?.first()?.value?.toFloat() ?: 20F

    internal suspend fun getFontSizeXL() = getContent().find {
        it.name == DS_FONT_SIZE_XL
    }?.values?.first()?.value?.toFloat() ?: 24F

    internal suspend fun getFontSizeXXL() = getContent().find {
        it.name == DS_FONT_SIZE_XXL
    }?.values?.first()?.value?.toFloat() ?: 32F

    internal suspend fun getFontSizeXXXL() = getContent().find {
        it.name == DS_FONT_SIZE_XXXL
    }?.values?.first()?.value?.toFloat() ?: 48F
}