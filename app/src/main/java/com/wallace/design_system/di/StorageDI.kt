package com.wallace.design_system.di

import android.app.Application
import androidx.room.Room
import com.wallace.design_system.data.storage.BaseDatabase
import com.wallace.design_system.data.storage.DesignSystemDAO
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.Module
import org.koin.dsl.module

class StorageDI {
    fun getModule(): Module {
        return module {
            fun provideDataBase(application: Application): BaseDatabase {
                return Room.databaseBuilder(
                    application,
                    BaseDatabase::class.java,
                    "database-designsystem"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            fun provideDao(dataBase: BaseDatabase): DesignSystemDAO = dataBase.designSystemDAO()
            single { provideDataBase(androidApplication()) }
            single { provideDao(get()) }
        }
    }
}