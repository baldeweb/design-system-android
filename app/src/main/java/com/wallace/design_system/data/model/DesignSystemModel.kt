package com.wallace.design_system.data.model

import com.google.gson.annotations.SerializedName

class DesignSystemModel{
    data class Response(
        @SerializedName("version")
        var version: Int? = null,
        @SerializedName("data")
        var tokens: ArrayList<Data>? = arrayListOf()
    )

    data class Data(
        @SerializedName("category")
        var tokens: ArrayList<DesignSystemModelItem>? = arrayListOf()
    )

    data class DesignSystemModelItem(
        @SerializedName("category")
        var category: String? = null,
        @SerializedName("ds_tokens")
        var dsTokens: ArrayList<DsToken>? = arrayListOf()
    )

    data class DsToken(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("type")
        var type: String? = null,
        @SerializedName("values")
        var values: ArrayList<Value>? = arrayListOf()
    )

    data class Value(
        @SerializedName("alpha")
        var alpha: Double? = null,
        @SerializedName("reference")
        var reference: String? = null,
        @SerializedName("value")
        var value: String? = null,
        @SerializedName("weight")
        var weight: Double? = null
    )
}