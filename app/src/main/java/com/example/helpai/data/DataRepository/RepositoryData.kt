package com.example.helpai.data.DataRepository

import android.util.Log
import com.example.helpai.ConnectApi.ModelResponse.CandidatesResnponse
import com.example.helpai.ConnectApi.ModelResponse.Content
import com.example.helpai.ConnectApi.ModelResponse.TextRespons
import com.example.helpai.ConnectApi.ModelResponse.parts
import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.Domain.mappingDomain.toDomain
import com.example.helpai.data.DataSourse.RetrofitGet
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryData @Inject constructor(
    private val retrofitGet: RetrofitGet
) : Data {

    override suspend fun getRespons(getText: String): Flow<List<ModelsDomain>> {
        return flow {

            val response = retrofitGet.getResponse(promtText = getText)

            Log.d("RepositoryData", "Raw response: ${response.candidatesRespons}")

            val parts = response.candidatesRespons?.firstOrNull()?.content?.parts

            if (parts != null) {
                val firstText = parts.firstOrNull()?.text

                Log.d("GeminiResponse", firstText ?: "No text found")

                emit(parts?.map { it.toDomain() } ?: emptyList())

            }


            Log.d("GeminiResponse", "Parsed response: ${parts?.map { it.toDomain() }}")
        }
    }

}




