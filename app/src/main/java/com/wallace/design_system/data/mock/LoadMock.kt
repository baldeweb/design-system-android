package com.wallace.design_system.data.mock

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class LoadMock(
    val jsonFileName: String
)