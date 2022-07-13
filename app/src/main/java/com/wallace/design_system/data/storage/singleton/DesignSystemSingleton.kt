package com.wallace.design_system.data.storage.singleton

import android.content.Context
import com.wallace.design_system.data.model.DesignSystemModel

class DesignSystemSingleton private constructor(context: Context) {
    var model: DesignSystemModel.Response? = null

    companion object : SingletonHolder<DesignSystemSingleton, Context>(::DesignSystemSingleton)
}