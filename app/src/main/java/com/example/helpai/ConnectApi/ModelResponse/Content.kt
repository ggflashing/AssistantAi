package com.example.helpai.ConnectApi.ModelResponse

import com.example.helpai.ConnectApi.ModelRequst.Parts
import com.google.gson.annotations.SerializedName

data class Content(

    @SerializedName("content")
    val content: parts,

    @SerializedName("finishReason")
    val finishReason: String? = null,

    @SerializedName("index")
    val index: Int
)

