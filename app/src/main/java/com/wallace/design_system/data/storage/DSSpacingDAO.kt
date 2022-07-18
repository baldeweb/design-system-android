package com.wallace.design_system.data.storage

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.wallace.design_system.data.model.DesignSystemModel
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_GIANT
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_HUGE
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_LG
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_MD
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_NANO
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_QUARCK
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_SM
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XL
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XS
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXL
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXS
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXXL
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_XXXS
import com.wallace.design_system.data.utils.convertToObject

class DSSpacingDAO(
    context: Context, dataStore: DataStore<Preferences>, prefsKey: Preferences.Key<String>
) : DataStoreManager<String>(context, dataStore, prefsKey) {
    private suspend fun getContent(): ArrayList<DesignSystemModel.DsToken> = getData().convertToObject()

    internal suspend fun getSpacingQuarck() = getContent().find {
        it.name == DS_SPACING_QUARCK
    }
    internal suspend fun getSpacingNano() = getContent().find {
        it.name == DS_SPACING_NANO
    }
    internal suspend fun getSpacingXxxs() = getContent().find {
        it.name == DS_SPACING_XXXS
    }
    internal suspend fun getSpacingXxs() = getContent().find {
        it.name == DS_SPACING_XXS
    }
    internal suspend fun getSpacingXs() = getContent().find {
        it.name == DS_SPACING_XS
    }
    internal suspend fun getSpacingSm() = getContent().find {
        it.name == DS_SPACING_SM
    }
    internal suspend fun getSpacingMd() = getContent().find {
        it.name == DS_SPACING_MD
    }
    internal suspend fun getSpacingLg() = getContent().find {
        it.name == DS_SPACING_LG
    }
    internal suspend fun getSpacingXl() = getContent().find {
        it.name == DS_SPACING_XL
    }
    internal suspend fun getSpacingXxl() = getContent().find {
        it.name == DS_SPACING_XXL
    }
    internal suspend fun getSpacingXxxl() = getContent().find {
        it.name == DS_SPACING_XXXL
    }
    internal suspend fun getSpacingHuge() = getContent().find {
        it.name == DS_SPACING_HUGE
    }
    internal suspend fun getSpacingGiant() = getContent().find {
        it.name == DS_SPACING_GIANT
    }
}