package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_INTENSE
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_LIGHT
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_MEDIUM
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_SEMIOPAQUE
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_SEMI_TRANSPARENT
import com.wallace.design_system.data.utils.convertToObject

class DSOpacityLevelsDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): DesignSystemModel.Value? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getOpacityLevelSemiOpaque() = getContent().find {
        it.name == DS_OPACITY_LEVEL_SEMIOPAQUE
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getOpacityLevelIntense() = getContent().find {
        it.name == DS_OPACITY_LEVEL_INTENSE
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getOpacityLevelMedium() = getContent().find {
        it.name == DS_OPACITY_LEVEL_MEDIUM
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getOpacityLevelLight() = getContent().find {
        it.name == DS_OPACITY_LEVEL_LIGHT
    }?.values?.first()?.value?.toFloat() ?: 1F

    internal suspend fun getOpacityLevelSemiTransparent() = getContent().find {
        it.name == DS_OPACITY_LEVEL_SEMI_TRANSPARENT
    }?.values?.first()?.value?.toFloat() ?: 1F
}