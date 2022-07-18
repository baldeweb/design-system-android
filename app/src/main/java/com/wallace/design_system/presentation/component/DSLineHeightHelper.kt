package com.wallace.design_system.presentation.component

import com.wallace.design_system.data.storage.DSLineHeightDAO
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_DEFAULT
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_LG
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_MD
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_SM
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_XL
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_XS
import com.wallace.design_system.data.utils.DSLineHeightConstants.DS_LINE_HEIGHT_XXL

interface DSLineHeightHelper {
    suspend fun getLineHeight(lineHeightDAO: DSLineHeightDAO, value: String): Float = when (value) {
        DS_LINE_HEIGHT_DEFAULT -> lineHeightDAO.getLineHeightDefault()
        DS_LINE_HEIGHT_XS -> lineHeightDAO.getLineHeightXs()
        DS_LINE_HEIGHT_SM -> lineHeightDAO.getLineHeightSm()
        DS_LINE_HEIGHT_MD -> lineHeightDAO.getLineHeightMd()
        DS_LINE_HEIGHT_LG -> lineHeightDAO.getLineHeightLg()
        DS_LINE_HEIGHT_XL -> lineHeightDAO.getLineHeightXl()
        DS_LINE_HEIGHT_XXL -> lineHeightDAO.getLineHeightXxl()
        else -> 1F
    }
}