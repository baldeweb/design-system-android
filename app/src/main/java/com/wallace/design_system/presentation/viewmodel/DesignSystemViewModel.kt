package com.wallace.design_system.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_COLOR
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_FONT_FAMILY
import com.wallace.design_system.data.utils.DesignSystemEnum.DS_SHADOW
import com.wallace.design_system.data.utils.LogUtils.logD
import com.wallace.design_system.domain.use_case.DesignSystemUseCase
import kotlinx.coroutines.launch

class DesignSystemViewModel(
    val useCase: DesignSystemUseCase
) : BaseViewModel() {

    fun getDesignSystem() {
         viewModelScope.launch(apiException) {
            serviceCaller(useCase.getDesignSystem(), {
                //logD("Response: ${it.toString()}")
                getFontFamily()
                getColor()
                getShadow()
            }, {
                logD("Error: $it")
            })
        }
    }

    private suspend fun getFontFamily() {
        val fontFamily = useCase.getDesignSystemByCategory(DS_FONT_FAMILY)
        logD("Font-Family: $fontFamily")
    }

    private suspend fun getColor() {
        val color = useCase.getDesignSystemByCategory(DS_COLOR)
        logD("Color: $color")
    }

    private suspend fun getShadow() {
        val shadow = useCase.getDesignSystemByCategory(DS_SHADOW)
        logD("Shadow: $shadow")
    }
}