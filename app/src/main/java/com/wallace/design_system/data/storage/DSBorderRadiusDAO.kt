package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_CIRCULAR
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_LG
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_MD
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_NONE
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_PILL
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_SM
import com.wallace.design_system.data.utils.convertToObject

class DSBorderRadiusDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): List<DesignSystemModel.Value>? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getBorderRadiusNone() = getContent().find {
        it.name == DS_BORDER_RADIUS_NONE
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderRadiusSm() = getContent().find {
        it.name == DS_BORDER_RADIUS_SM
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderRadiusMd() = getContent().find {
        it.name == DS_BORDER_RADIUS_MD
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderRadiusLg() = getContent().find {
        it.name == DS_BORDER_RADIUS_LG
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderRadiusPill() = getContent().find {
        it.name == DS_BORDER_RADIUS_PILL
    }?.values?.first()?.value?.toInt() ?: 0

    internal suspend fun getBorderRadiusCircular() = getContent().find {
        it.name == DS_BORDER_RADIUS_CIRCULAR
    }?.values?.first()?.value?.toInt() ?: 0
}