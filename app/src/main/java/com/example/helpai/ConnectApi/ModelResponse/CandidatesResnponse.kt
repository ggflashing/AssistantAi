package com.example.helpai.ConnectApi.ModelResponse

import com.google.gson.annotations.SerializedName

data class CandidatesResnponse(

    @SerializedName("candidates")
    val candidatesRespons: List<Content>,

    @SerializedName("usageMetadata")
    val usageMetadata: UsageMetadata? = null,

    @SerializedName("modelVersion")

    val modelVersion: String? = null,

    @SerializedName("responseId")
    val responseId: String? = null

)
