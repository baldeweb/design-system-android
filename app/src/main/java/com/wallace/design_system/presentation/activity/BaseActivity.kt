package com.wallace.design_system.presentation.activity

import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.wallace.design_system.data.utils.LogUtils.logD
import com.wallace.design_system.databinding.ActivityMainBinding
import com.wallace.design_system.presentation.viewmodel.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class BaseActivity<T : BaseViewModel> : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    protected lateinit var viewModel: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.setContentView(binding.root)
        initViewModels()
    }

    override fun setContentView(view: View?) {
        binding.fmlBaseLayout.addView(view)
    }

    private fun initViewModels() {
        viewModel = getViewModel(clazz = viewModelClass())

        viewModel.setContext(this)

        viewModel.errorResponse.observe(this) {
            logD("Erro: $it")
        }

        viewModel.shouldShowLoading.observe(this) {
            if (it) showLoading() else dismissLoading()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun viewModelClass(): KClass<T> {
        return try {
            ((javaClass.genericSuperclass as ParameterizedType)
                .actualTypeArguments[0] as Class<T>).kotlin
        } catch (e: Exception) {
            return Any() as KClass<T>
        }
    }

    open fun showLoading() {
        runOnUiThread {
            binding.lltLoading.isClickable = false
            if (binding.lltLoading.visibility == View.GONE) {
                binding.lltLoading.visibility = View.VISIBLE
                binding.lltLoading.animation = AlphaAnimation(0F, 1F).apply { duration = 300 }
            }
        }
    }

    open fun dismissLoading() {
        runOnUiThread {
            binding.lltLoading.isClickable = false
            if (binding.lltLoading.visibility == View.VISIBLE) {
                binding.lltLoading.animation = AlphaAnimation(1F, 0F).apply { duration = 150 }
            }
            binding.lltLoading.visibility = View.GONE
        }
    }
}