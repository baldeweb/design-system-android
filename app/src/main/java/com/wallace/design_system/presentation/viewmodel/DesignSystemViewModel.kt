package com.wallace.design_system.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.wallace.design_system.data.utils.LogUtils.logD
import com.wallace.design_system.domain.use_case.DesignSystemUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DesignSystemViewModel(
    val useCase: DesignSystemUseCase
) : BaseViewModel() {

    fun getDesignSystem() {
         CoroutineScope(Dispatchers.IO).launch(apiException) {
            serviceCaller(useCase.getDesignSystem(), {
                logD("Response: ${it.toString()}")
                getDesignSystemStorage()
            }, {
                logD("Error: $it")
            })
        }
    }

    private suspend fun getDesignSystemStorage() {
        val data = useCase.getDesignSystemStorage()
        logD("Storage: ${data}")
    }
}