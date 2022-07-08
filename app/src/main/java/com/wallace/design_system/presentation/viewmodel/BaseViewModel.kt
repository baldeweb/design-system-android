package com.wallace.design_system.presentation.viewmodel

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wallace.design_system.data.utils.LogUtils
import com.wallace.design_system.data.utils.SingleLiveEvent
import kotlinx.coroutines.CoroutineExceptionHandler

open class BaseViewModel: ViewModel() {

    private var _errorResponse = MutableLiveData<String?>()
    var errorResponse: LiveData<String?> = _errorResponse

    private var _currentContext = MutableLiveData<AppCompatActivity>()
    val currentContext: LiveData<AppCompatActivity> = _currentContext

    private var _shouldShowLoading = SingleLiveEvent<Boolean>()
    var shouldShowLoading: LiveData<Boolean> = _shouldShowLoading

    protected val apiException = CoroutineExceptionHandler { _, exception ->
        LogUtils.logD("Erro: ${exception.message ?: ""}")
    }

    fun setContext(context: AppCompatActivity) {
        _currentContext.value = context
    }

    fun getContext() = _currentContext.value

    protected fun showLoading() {
        _shouldShowLoading.postValue(true)
    }

    protected fun dismissLoading() {
        _shouldShowLoading.postValue(false)
    }
}