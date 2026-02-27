package com.example.helpai.ConnectApi.ModelRequst

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TextRequst(

    @SerializedName("text")
    val text: String

)
