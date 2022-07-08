package com.wallace.design_system

import com.wallace.design_system.data.service.ServiceManager
import com.wallace.design_system.domain.DesignSystemRepository
import com.wallace.design_system.domain.DesignSystemRepositoryImpl
import com.wallace.design_system.presentation.viewmodel.BaseViewModel
import com.wallace.design_system.presentation.viewmodel.DesignSystemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.KClass

class DesignSystemDI {
    fun getModule(): Module {
        return module {
            single { ServiceManager<KClass<*>>(get()) }

            factory<DesignSystemRepository> { DesignSystemRepositoryImpl() }

            viewModel { BaseViewModel() }
            viewModel { DesignSystemViewModel() }
        }
    }
}