package com.example.helpai.ConnectApi.ModelResponse

import com.google.gson.annotations.SerializedName

data class UsageMetadata(


    @SerializedName("promptTokenCount")
    val promptTokenCount: Int,

    @SerializedName("candidatesTokenCount")
    val candidatesTokenCount: Int,

    @SerializedName("totalTokenCount")
    val totalTokenCount: Int,

    @SerializedName("promptTokensDetails")
    val promptTokensDetails: List<TokenDetail>,

    @SerializedName("thoughtsTokenCount")
    val thoughtsTokenCount: Int

)
