package com.example.helpai.data.DataSourse

import android.util.Log
import com.example.helpai.ConnectApi.ServisApi
import com.example.helpai.BuildConfig
import com.example.helpai.ConnectApi.ModelRequst.ContentRequst
import com.example.helpai.ConnectApi.ModelRequst.Parts
import com.example.helpai.ConnectApi.ModelRequst.TextRequst
import com.example.helpai.ConnectApi.ModelResponse.CandidatesResnponse
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class RetrofitGet @Inject constructor(
    private val api: ServisApi,
    private val chatDao: Dao
) {
    private val geminiApiKey = BuildConfig.GeminiApiKey.trim()
    suspend fun getResponse(promtText: String): CandidatesResnponse{

        chatDao.insert(ChatMessageEntity(role = "user", text = promtText))

        val history = chatDao.getAllListChat().first()

        val request = ContentRequst(
            content = history.takeLast(20).map { message ->
                Parts(
                    role = message.role,
                    part = listOf(
                        TextRequst(message.text)
                    )
                )
            }
        )

        val response = api.getContent(
            Apikey = geminiApiKey,
            responsPromt = request
        )

        val modelText = response.candidatesRespons?.firstOrNull()?.content?.parts?.firstOrNull()?.text ?: ""

        chatDao.insert(ChatMessageEntity(role = "model", text = modelText))

        Log.d("GeminiResponse", "Raw Response: $response")

        return response
    }
}