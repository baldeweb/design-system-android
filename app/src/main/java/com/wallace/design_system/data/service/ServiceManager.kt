package com.wallace.design_system.data.service

import android.content.Context
import com.google.gson.GsonBuilder
import com.wallace.design_system.BuildConfig
import com.wallace.design_system.data.mock.MockInterceptor
import com.wallace.design_system.data.utils.ServiceConstants.TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

open class ServiceManager<T>(private val context: Context) : KoinComponent {

    protected inline fun <reified T> create(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            )
            .client(getOkHttpClient().build())
            .build()

        return retrofit.create(T::class.java)
    }

    fun getOkHttpClient(): OkHttpClient.Builder {
        val okHttpClient: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttpClient.connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.readTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        okHttpClient.build()

        val interceptor = HttpLoggingInterceptor()
        interceptor.level =
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE

        okHttpClient.addInterceptor(interceptor)
        okHttpClient.addInterceptor { chain ->
            val request: Request = chain.request().newBuilder()
                .addHeader("Content-Type", "application/json")
                .build()
            chain.proceed(request)
        }

        context.let { okHttpClient.addInterceptor(MockInterceptor(it)) }

        return okHttpClient
    }
}