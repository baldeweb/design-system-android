package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_HAIRLINE
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_HEAVY
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_NONE
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_THICK
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_THIN
import com.wallace.design_system.data.utils.convertToObject

class DSBorderWidthDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): DesignSystemModel.Value? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getBorderWidthNone() = getContent().find {
        it.name == DS_BORDER_WIDTH_NONE
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderWidthHairline() = getContent().find {
        it.name == DS_BORDER_WIDTH_HAIRLINE
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderWidthThin() = getContent().find {
        it.name == DS_BORDER_WIDTH_THIN
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderWidthThick() = getContent().find {
        it.name == DS_BORDER_WIDTH_THICK
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderWidthHeavy() = getContent().find {
        it.name == DS_BORDER_WIDTH_HEAVY
    }?.values?.first()?.value?.toInt() ?: 0
}