package com.wallace.design_system.data.model

import com.google.gson.annotations.SerializedName

class DesignSystemModel{
    data class Response(
        @SerializedName("version")
        var version: Long? = null,
        @SerializedName("data")
        var listData: List<Data>? = arrayListOf()
    ) {
        override fun toString(): String {
            return "Response(version=$version, listData=$listData)"
        }
    }

    data class Data(
        @SerializedName("category")
        var category: String? = null,
        @SerializedName("ds_tokens")
        var dsTokens: List<DsToken>? = arrayListOf()
    ) {
        override fun toString(): String {
            return "Data(category=$category, dsTokens=$dsTokens)"
        }
    }

    data class DsToken(
        @SerializedName("name")
        var name: String? = null,
        @SerializedName("type")
        var type: String? = null,
        @SerializedName("values")
        var values: List<Value>? = arrayListOf()
    ) {
        override fun toString(): String {
            return "DsToken(name=$name, type=$type, values=$values)"
        }
    }

    data class Value(
        @SerializedName("alpha")
        var alpha: Double? = null,
        @SerializedName("reference")
        var reference: String? = null,
        @SerializedName("value")
        var value: String? = null,
        @SerializedName("weight")
        var weight: Double? = null
    ) {
        override fun toString(): String {
            return "Value(alpha=$alpha, reference=$reference, value=$value, weight=$weight)"
        }
    }

    data class DSShadow(
        var value: DSShadowValue? = null,
        var alpha: Double? = null,
        var reference: String? = null
    ) {
        override fun toString(): String {
            return "DSShadow(value=$value, alpha=$alpha, reference=$reference)"
        }
    }

    data class DSShadowValue(
        var x: Int? = null,
        var y: Int? = null,
        var b: Int? = null
    ) {
        override fun toString(): String {
            return "DSShadowValue(x=$x, y=$y, b=$b)"
        }
    }
}