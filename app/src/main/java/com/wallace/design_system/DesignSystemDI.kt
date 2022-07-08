package com.wallace.design_system

import com.wallace.design_system.data.service.ServiceManager
import org.koin.core.module.Module
import org.koin.dsl.module
import kotlin.reflect.KClass

class DesignSystemDI {
    fun getModule(): Module {
        return module {
            single { ServiceManager<KClass<*>>(get()) }
        }
    }
}