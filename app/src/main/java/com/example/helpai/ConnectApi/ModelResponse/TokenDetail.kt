package com.example.helpai.ConnectApi.ModelResponse

import com.google.gson.annotations.SerializedName

data class TokenDetail(

    @SerializedName("modality")
    val modality: String,
    @SerializedName("tokenCount")
    val tokenCount: Int

)
