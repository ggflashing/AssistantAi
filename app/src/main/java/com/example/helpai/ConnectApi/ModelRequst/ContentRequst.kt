package com.example.helpai.ConnectApi.ModelRequst

import com.google.gson.annotations.SerializedName

data class ContentRequst(

    @SerializedName("contents")
    val content: List<Parts>
)
