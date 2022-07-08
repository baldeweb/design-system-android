package com.wallace.design_system.data.api

import com.wallace.design_system.data.mock.LoadMock
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface DesignSystemAPI {
    @LoadMock("design-system.json")
    @GET("Design/DesignSystem")
    suspend fun getDesignSystem(): Response<ResponseBody>
}