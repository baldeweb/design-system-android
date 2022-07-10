package com.wallace.design_system.data.mock

import android.content.Context
import android.content.res.AssetManager
import com.wallace.design_system.BuildConfig.BASE_URL
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody
import retrofit2.Invocation
import java.io.IOException
import java.io.InputStream

class MockInterceptor(val context: Context) : Interceptor {

    private fun readFile(fileName: String): String {
        val manager: AssetManager = context.assets
        val file: InputStream = manager.open(fileName)
        val formArray = ByteArray(file.available())
        file.read(formArray)
        file.close()
        return String(formArray)
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val invocation = chain.request().tag(Invocation::class.java)
        val builder = chain.request().newBuilder()
        invocation?.method()?.annotations?.let { annotations ->
            annotations.forEach { annotation ->
                when (annotation.annotationClass) {
                    LoadMock::class -> {
                        (annotation as LoadMock).apply {
                            val response = readFile("mocks/$jsonFileName")
                            return try {
                                chain.proceed(chain.request())
                                    .newBuilder()
                                    .code(200)
                                    .protocol(Protocol.HTTP_2)
                                    .message(response)
                                    .body(
                                        response
                                            .toByteArray()
                                            .toResponseBody(
                                                "application/json"
                                                    .toMediaTypeOrNull()
                                            )
                                    )
                                    .addHeader("content-type", "application/json")
                                    .build()
                            } catch (exception: IOException) {
                                val result = Response.Builder().code(200)
                                    .request(
                                        Request.Builder()
                                            .url(BASE_URL)
                                            .build()
                                    )
                                    .protocol(Protocol.HTTP_2)
                                    .message(response)
                                    .body(
                                        response
                                            .toByteArray()
                                            .toResponseBody(
                                                "application/json"
                                                    .toMediaTypeOrNull()
                                            )
                                    )
                                    .addHeader("content-type", "application/json")
                                    .build()
                                result
                            }
                        }
                    }
                }
            }
        }

        return chain.proceed(builder.build())
    }
}