package com.wallace.design_system.domain

import retrofit2.Response
import retrofit2.http.Body

interface DesignSystemRepository {
    fun getDesignSystem(): Response<Body>?
}