package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_DEFAULT
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_LG
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_MD
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_SM
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_XL
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_XS
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_LINE_HEIGHT_XXL
import com.wallace.design_system.data.utils.convertToObject

class DSLineHeightDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): List<DesignSystemModel.Value>? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getLineHeightDefault() = getContent().find {
        it.name == DS_LINE_HEIGHT_DEFAULT
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getLineHeightXs() = getContent().find {
        it.name == DS_LINE_HEIGHT_XS
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getLineHeightSm() = getContent().find {
        it.name == DS_LINE_HEIGHT_SM
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getLineHeightMd() = getContent().find {
        it.name == DS_LINE_HEIGHT_MD
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getLineHeightLg() = getContent().find {
        it.name == DS_LINE_HEIGHT_LG
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getLineHeightXl() = getContent().find {
        it.name == DS_LINE_HEIGHT_XL
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getLineHeightXxl() = getContent().find {
        it.name == DS_LINE_HEIGHT_XXL
    }?.values?.first()?.value?.toFloat() ?: 1F
}