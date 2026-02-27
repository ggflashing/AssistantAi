package com.example.helpai.data.DataSourse

import android.util.Log
import com.example.helpai.ConnectApi.ServisApi
import com.example.helpai.BuildConfig
import com.example.helpai.ConnectApi.ModelRequst.ContentRequst
import com.example.helpai.ConnectApi.ModelRequst.Parts
import com.example.helpai.ConnectApi.ModelRequst.TextRequst
import com.example.helpai.ConnectApi.ModelResponse.CandidatesResnponse
import com.google.gson.GsonBuilder
import javax.inject.Inject

class RetrofitGet @Inject constructor(private val api: ServisApi)  {

    private val geminiApiKey = BuildConfig.GeminiApiKey.trim()

    suspend fun getResponse(promtText: String): CandidatesResnponse{

        val text = ContentRequst(
            content = listOf(
                Parts(
                    role = "user",
                    part = listOf(TextRequst(promtText))

                )

            )
        )

        val gson = GsonBuilder().setPrettyPrinting().create()
        Log.d("RetrofitRequest", gson.toJson(text))

        Log.d("GeminiResponse", gson.toJson(text))

        val response = api.getContent(Apikey = geminiApiKey, responsPromt = text)

        Log.d("GeminiResponse", "Raw Response: $response")

        return response



    }
}