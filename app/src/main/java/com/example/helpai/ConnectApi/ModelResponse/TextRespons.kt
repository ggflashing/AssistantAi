package com.example.helpai.ConnectApi.ModelResponse

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TextRespons(

    @SerializedName("text")
    val text: String

)