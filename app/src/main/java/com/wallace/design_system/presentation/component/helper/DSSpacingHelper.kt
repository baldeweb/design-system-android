package com.wallace.design_system.presentation.component.helper

import com.wallace.design_system.data.storage.DSSpacingDAO
import com.wallace.design_system.data.storage.DSSpacingInsetDAO
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_GIANT
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_HUGE
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_LG
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_MD
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_NANO
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_QUARCK
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_SM
import com.wallace.design_system.data.utils.DSSpacingConstants.DS_SPACING_INSET_XS
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

interface DSSpacingHelper {
    suspend fun getSpacing(spacingDAO: DSSpacingDAO, value: String): Int = when (value) {
        DS_SPACING_QUARCK -> spacingDAO.getSpacingQuarck()
        DS_SPACING_NANO -> spacingDAO.getSpacingNano()
        DS_SPACING_XXXS -> spacingDAO.getSpacingXxxs()
        DS_SPACING_XXS -> spacingDAO.getSpacingXxs()
        DS_SPACING_XS -> spacingDAO.getSpacingXs()
        DS_SPACING_SM -> spacingDAO.getSpacingSm()
        DS_SPACING_MD -> spacingDAO.getSpacingMd()
        DS_SPACING_LG -> spacingDAO.getSpacingLg()
        DS_SPACING_XL -> spacingDAO.getSpacingXl()
        DS_SPACING_XXL -> spacingDAO.getSpacingXxl()
        DS_SPACING_XXXL -> spacingDAO.getSpacingXxxl()
        DS_SPACING_HUGE -> spacingDAO.getSpacingHuge()
        DS_SPACING_GIANT -> spacingDAO.getSpacingGiant()
        else -> 14
    }

    suspend fun getSpacingInset(spacingInsetDAO: DSSpacingInsetDAO, value: String): Int =
        when (value) {
            DS_SPACING_INSET_QUARCK -> spacingInsetDAO.getSpacingInsetQuarck()
            DS_SPACING_INSET_NANO -> spacingInsetDAO.getSpacingInsetNano()
            DS_SPACING_INSET_XS -> spacingInsetDAO.getSpacingInsetXs()
            DS_SPACING_INSET_SM -> spacingInsetDAO.getSpacingInsetSm()
            DS_SPACING_INSET_MD -> spacingInsetDAO.getSpacingInsetMd()
            DS_SPACING_INSET_LG -> spacingInsetDAO.getSpacingInsetLg()
            else -> 14
        }
}