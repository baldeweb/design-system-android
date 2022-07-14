package com.wallace.design_system

import android.app.Application
import android.content.Context
import com.wallace.design_system.di.ComponentDI
import com.wallace.design_system.di.DesignSystemDI
import com.wallace.design_system.di.StorageDI
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DesignSystemApplication : Application() {

    companion object {
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        val moduleList = listOf(
            ComponentDI().getModule(),
            DesignSystemDI().getModule(),
            StorageDI().getModule(),
        )
        startKoin {
            androidContext(this@DesignSystemApplication)
            modules(moduleList)
        }
    }
}