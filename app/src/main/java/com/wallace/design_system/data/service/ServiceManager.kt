package com.wallace.design_system.data.service

import android.content.Context
import com.google.gson.GsonBuilder
import com.wallace.design_system.BuildConfig
import com.wallace.design_system.BuildConfig.BASE_URL
import com.wallace.design_system.data.mock.MockInterceptor
import com.wallace.design_system.data.utils.ServiceConstants.TIMEOUT
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection.*
import java.util.concurrent.TimeUnit

open class ServiceManager<T>(private val context: Context) : KoinComponent {

     inline fun <reified T> create(): T {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
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

    internal suspend fun <T> serviceCaller(
        api: Response<T>?,
        onResponse: suspend (T?) -> Unit,
        onErrorResponse: ((String) -> Unit)? = null
    ) {
        when {
            (HTTP_OK..HTTP_PARTIAL).find { it == api?.code() } != null -> {
                api?.body()?.let {
                    onResponse.invoke(it)
                } ?: run {
                    onErrorResponse?.invoke("Error")
                }
            }
            (HTTP_BAD_REQUEST..HTTP_VERSION).find { it == api?.code() } != null -> {
                onErrorResponse?.invoke("Error")
            }
            else -> {
                onErrorResponse?.invoke("Error")
            }
        }
    }
}