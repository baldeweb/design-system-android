package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_OPACITY_LEVEL_INTENSE
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_OPACITY_LEVEL_LIGHT
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_OPACITY_LEVEL_MEDIUM
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_OPACITY_LEVEL_SEMIOPAQUE
import com.wallace.design_system.data.utils.DSMiscellaneousConstants.DS_OPACITY_LEVEL_SEMI_TRANSPARENT
import com.wallace.design_system.data.utils.convertToObject

class DSOpacityLevelsDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): List<DesignSystemModel.Value>? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getOpacityLevelSemiOpaque() = getContent().find {
        it.name == DS_OPACITY_LEVEL_SEMIOPAQUE
    }
    internal suspend fun getOpacityLevelIntense() = getContent().find {
        it.name == DS_OPACITY_LEVEL_INTENSE
    }
    internal suspend fun getOpacityLevelMedium() = getContent().find {
        it.name == DS_OPACITY_LEVEL_MEDIUM
    }
    internal suspend fun getOpacityLevelLight() = getContent().find {
        it.name == DS_OPACITY_LEVEL_LIGHT
    }
    internal suspend fun getOpacityLevelSemiTransparent() = getContent().find {
        it.name == DS_OPACITY_LEVEL_SEMI_TRANSPARENT
    }
}