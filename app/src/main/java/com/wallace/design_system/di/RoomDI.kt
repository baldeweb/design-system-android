package com.wallace.design_system.di

import com.wallace.design_system.data.storage.BaseDatabase
import org.koin.core.module.Module
import org.koin.dsl.module

class RoomDI {
    fun getModule(): Module {
        return module {
            //single { BaseDatabase(get()) }
        }
    }
}