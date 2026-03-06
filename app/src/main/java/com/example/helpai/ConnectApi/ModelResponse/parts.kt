package com.example.helpai.ConnectApi.ModelResponse

import com.example.helpai.ConnectApi.ModelRequst.TextRequst
import com.google.gson.annotations.SerializedName

data class parts(

    @SerializedName("parts")
    val parts: List<TextRespons>,

    @SerializedName("role")
    val role: String?,

    )