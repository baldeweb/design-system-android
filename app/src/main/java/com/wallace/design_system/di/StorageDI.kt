package com.wallace.design_system.di

import android.app.Application
import androidx.room.Room
import com.wallace.design_system.data.storage.room.*
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

            fun provideDesignSystemDao(dataBase: BaseDatabase): DesignSystemDAO = dataBase.designSystemDAO()
            fun provideFontFamilyDao(dataBase: BaseDatabase): FontFamilyDAO = dataBase.fontFamilyDAO()
            fun provideFontWeightDao(dataBase: BaseDatabase): FontWeightDAO = dataBase.fontWeightDAO()
            fun provideGradientColorDao(dataBase: BaseDatabase): GradientColorDAO = dataBase.gradientColorDAO()
            fun provideColorDao(dataBase: BaseDatabase): ColorDAO = dataBase.colorDAO()
            fun provideFontSizeDao(dataBase: BaseDatabase): FontSizeDAO = dataBase.fontSizeDAO()
            fun provideShadowDao(dataBase: BaseDatabase): ShadowDAO = dataBase.shadowDAO()

            single { provideDataBase(androidApplication()) }
            single { provideDesignSystemDao(get()) }
            single { provideFontFamilyDao(get()) }
            single { provideFontWeightDao(get()) }
            single { provideGradientColorDao(get()) }
            single { provideColorDao(get()) }
            single { provideFontSizeDao(get()) }
            single { provideShadowDao(get()) }
        }
    }
}