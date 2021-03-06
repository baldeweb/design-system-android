package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_LG
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_MD
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_NANO
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_QUARCK
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_SM
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_XS
import com.wallace.design_system.data.utils.convertToObject

class DSSpacingInsetDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey), DataStoreHelper {

    override suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> =
        getData().convertToObject()

    override suspend fun getTokenByReference(referenceName: String): DesignSystemModel.Value? {
        return super.getTokenByReference(referenceName)
    }

    internal suspend fun getSpacingInsetQuarck() = getContent().find {
        it.name == DS_SPACING_INSET_QUARCK
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingInsetNano() = getContent().find {
        it.name == DS_SPACING_INSET_NANO
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingInsetXs() = getContent().find {
        it.name == DS_SPACING_INSET_XS
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingInsetSm() = getContent().find {
        it.name == DS_SPACING_INSET_SM
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingInsetMd() = getContent().find {
        it.name == DS_SPACING_INSET_MD
    }?.values?.first()?.value?.toInt() ?: 10

    internal suspend fun getSpacingInsetLg() = getContent().find {
        it.name == DS_SPACING_INSET_LG
    }?.values?.first()?.value?.toInt() ?: 10
}