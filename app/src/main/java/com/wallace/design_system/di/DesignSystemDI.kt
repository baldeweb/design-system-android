package com.wallace.design_system.di

import com.wallace.design_system.data.service.ServiceManager
import com.wallace.design_system.data.storage.DesignSystemDAO
import com.wallace.design_system.domain.base.BaseRepository
import com.wallace.design_system.domain.base.BaseUseCase
import com.wallace.design_system.domain.repository.DesignSystemRepository
import com.wallace.design_system.domain.repository.DesignSystemRepositoryImpl
import com.wallace.design_system.domain.use_case.DesignSystemUseCase
import com.wallace.design_system.domain.use_case.DesignSystemUseCaseImpl
import com.wallace.design_system.presentation.viewmodel.BaseViewModel
import com.wallace.design_system.presentation.viewmodel.DesignSystemViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.KClass

class DesignSystemDI {
    fun getModule(): Module {
        return module {
            single { BaseRepository<KClass<*>>(get()) }
            single { BaseUseCase() }

            single { ServiceManager<KClass<*>>(get()) }

            factory<DesignSystemRepository> { DesignSystemRepositoryImpl(get()) }
            factory<DesignSystemUseCase> { DesignSystemUseCaseImpl(get<DesignSystemDAO>(), get()) }

            viewModel { BaseViewModel() }
            viewModel { DesignSystemViewModel(get()) }
        }
    }
}