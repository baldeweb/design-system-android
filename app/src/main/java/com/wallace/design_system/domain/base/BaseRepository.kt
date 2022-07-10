package com.wallace.design_system.domain.base

import android.content.Context
import com.wallace.design_system.data.service.ServiceManager
import org.koin.core.component.KoinComponent

open class BaseRepository<T>(val context: Context) : KoinComponent {
    protected var api = ServiceManager<T>(context)
}