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
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getFontSizeXXS() = getContent().find {
        it.name == DS_FONT_SIZE_XXS
    }?.values?.first()?.value?.toInt() ?: 12

    internal suspend fun getFontSizeXS() = getContent().find {
        it.name == DS_FONT_SIZE_XS
    }?.values?.first()?.value?.toInt() ?: 14

    internal suspend fun getFontSizeSM() = getContent().find {
        it.name == DS_FONT_SIZE_SM
    }?.values?.first()?.value?.toInt() ?: 16

    internal suspend fun getFontSizeMD() = getContent().find {
        it.name == DS_FONT_SIZE_MD
    }?.values?.first()?.value?.toInt() ?: 18

    internal suspend fun getFontSizeLG() = getContent().find {
        it.name == DS_FONT_SIZE_LG
    }?.values?.first()?.value?.toInt() ?: 20

    internal suspend fun getFontSizeXL() = getContent().find {
        it.name == DS_FONT_SIZE_XL
    }?.values?.first()?.value?.toInt() ?: 24

    internal suspend fun getFontSizeXXL() = getContent().find {
        it.name == DS_FONT_SIZE_XXL
    }?.values?.first()?.value?.toInt() ?: 32

    internal suspend fun getFontSizeXXXL() = getContent().find {
        it.name == DS_FONT_SIZE_XXXL
    }?.values?.first()?.value?.toInt() ?: 48
}