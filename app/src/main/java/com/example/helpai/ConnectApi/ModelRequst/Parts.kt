package com.example.helpai.ConnectApi.ModelRequst

import com.google.gson.annotations.SerializedName

data class Parts(

    @SerializedName("role")
    val role: String?,

    @SerializedName("parts")
    val part: List<TextRequst>

)
