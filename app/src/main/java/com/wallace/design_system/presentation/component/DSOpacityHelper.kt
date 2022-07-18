package com.wallace.design_system.presentation.component

import com.wallace.design_system.data.storage.DSOpacityLevelsDAO
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_INTENSE
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_LIGHT
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_MEDIUM
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_SEMIOPAQUE
import com.wallace.design_system.data.utils.DSOpacityLevelsConstants.DS_OPACITY_LEVEL_SEMI_TRANSPARENT

interface DSOpacityHelper {
    suspend fun getOpacityLevels(
        opacityLevelDAO: DSOpacityLevelsDAO, value: String
    ): Float = when (value) {
        DS_OPACITY_LEVEL_SEMIOPAQUE -> opacityLevelDAO.getOpacityLevelSemiOpaque()
        DS_OPACITY_LEVEL_INTENSE -> opacityLevelDAO.getOpacityLevelIntense()
        DS_OPACITY_LEVEL_MEDIUM -> opacityLevelDAO.getOpacityLevelMedium()
        DS_OPACITY_LEVEL_LIGHT -> opacityLevelDAO.getOpacityLevelLight()
        DS_OPACITY_LEVEL_SEMI_TRANSPARENT -> opacityLevelDAO.getOpacityLevelSemiTransparent()
        else -> 1F
    }
}