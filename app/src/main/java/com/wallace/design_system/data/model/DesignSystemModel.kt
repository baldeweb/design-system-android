package com.wallace.design_system.data.model

import com.google.gson.annotations.SerializedName

class DesignSystemModel {
    data class Response(
        @SerializedName("componentItems")
        var items: ArrayList<DesignSystemModelItem>? = arrayListOf()
    )

    data class DesignSystemModelItem(
        @SerializedName("category")
        var category: String? = "",
        @SerializedName("ds_tokens")
        var dsTokens: List<DsToken?>? = listOf()
    )

    data class DsToken(
        @SerializedName("complement")
        var complement: String? = "",
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("values")
        var values: List<Any?>? = listOf()
    )
}