package com.wallace.design_system.data.api

import com.wallace.design_system.data.mock.LoadMock
import com.wallace.design_system.data.model.DesignSystemModel
import retrofit2.Response
import retrofit2.http.GET

interface DesignSystemAPI {
    @LoadMock("design-system.json")
    @GET("Design/DesignSystem")
    suspend fun getDesignSystem(): Response<ArrayList<DesignSystemModel.Response>>
}