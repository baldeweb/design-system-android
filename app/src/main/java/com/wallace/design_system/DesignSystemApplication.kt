package com.wallace.design_system

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class DesignSystemApplication: Application() {

    companion object{
        lateinit var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext

        val moduleList = listOf(DesignSystemDI().getModule())
        startKoin {
            androidContext(this@DesignSystemApplication)
            modules(moduleList)
        }
    }
}