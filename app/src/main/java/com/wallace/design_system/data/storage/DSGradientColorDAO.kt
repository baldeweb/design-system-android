package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_HIGHLIGHT
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_PRIMARY
import com.wallace.design_system.data.utils.DSColorConstants.DS_GRADIENT_COLOR_SECONDARY
import com.wallace.design_system.data.utils.convertToObject

class DSGradientColorDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): List<DesignSystemModel.Value>? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getGradientColorPrimary() = getContent().find {
        it.name == DS_GRADIENT_COLOR_PRIMARY
    }
    internal suspend fun getGradientColorSecondary() = getContent().find {
        it.name == DS_GRADIENT_COLOR_SECONDARY
    }
    internal suspend fun getGradientColorHighlight() = getContent().find {
        it.name == DS_GRADIENT_COLOR_HIGHLIGHT
    }
}