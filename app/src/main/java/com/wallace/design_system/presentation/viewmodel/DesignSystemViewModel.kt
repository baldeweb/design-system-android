package com.wallace.design_system.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.wallace.design_system.data.utils.LogUtils.logD
import com.wallace.design_system.domain.use_case.DesignSystemUseCase
import kotlinx.coroutines.launch

class DesignSystemViewModel(
    val useCase: DesignSystemUseCase
) : BaseViewModel() {

    fun getDesignSystem() {
        viewModelScope.launch(apiException) {
            serviceCaller(useCase.getDesignSystem(), {
                logD("Response: ${it.toString()}")
            }, {
                logD("Error: $it")
            })
        }
    }
}