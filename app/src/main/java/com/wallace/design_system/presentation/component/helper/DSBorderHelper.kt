package com.wallace.design_system.presentation.component.helper

import com.wallace.design_system.data.storage.DSBorderRadiusDAO
import com.wallace.design_system.data.storage.DSBorderWidthDAO
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_CIRCULAR
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_LG
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_MD
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_NONE
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_PILL
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_RADIUS_SM
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_HAIRLINE
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_HEAVY
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_NONE
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_THICK
import com.wallace.design_system.data.utils.DSBorderConstants.DS_BORDER_WIDTH_THIN

interface DSBorderHelper {
    suspend fun getBorderRadius(
        borderRadiusDAO: DSBorderRadiusDAO, value: String
    ): Int? = when (value) {
        DS_BORDER_RADIUS_NONE -> borderRadiusDAO.getBorderRadiusNone()
        DS_BORDER_RADIUS_SM -> borderRadiusDAO.getBorderRadiusSm()
        DS_BORDER_RADIUS_MD -> borderRadiusDAO.getBorderRadiusMd()
        DS_BORDER_RADIUS_LG -> borderRadiusDAO.getBorderRadiusLg()
        DS_BORDER_RADIUS_PILL -> borderRadiusDAO.getBorderRadiusPill()
        DS_BORDER_RADIUS_CIRCULAR -> borderRadiusDAO.getBorderRadiusCircular()
        else -> 0
    }

    suspend fun getBorderWidth(borderWidthDAO: DSBorderWidthDAO, value: String): Int? =
        when (value) {
            DS_BORDER_WIDTH_NONE -> borderWidthDAO.getBorderWidthNone()
            DS_BORDER_WIDTH_HAIRLINE -> borderWidthDAO.getBorderWidthHairline()
            DS_BORDER_WIDTH_THIN -> borderWidthDAO.getBorderWidthThin()
            DS_BORDER_WIDTH_THICK -> borderWidthDAO.getBorderWidthThick()
            DS_BORDER_WIDTH_HEAVY -> borderWidthDAO.getBorderWidthHeavy()
            else -> 0
        }
}