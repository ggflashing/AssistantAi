package com.example.helpai.ConnectApi.ModelRequst

import com.google.gson.annotations.SerializedName

data class Parts(

    @SerializedName("parts")
    val part: List<TextRequst>,

    @SerializedName("role")
    val role: String?,

)
