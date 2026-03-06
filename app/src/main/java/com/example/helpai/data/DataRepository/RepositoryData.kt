package com.example.helpai.data.DataRepository

import android.util.Log
import com.example.helpai.ConnectApi.ModelResponse.CandidatesResnponse
import com.example.helpai.ConnectApi.ModelResponse.Content
import com.example.helpai.ConnectApi.ModelResponse.TextRespons
import com.example.helpai.ConnectApi.ModelResponse.parts
import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.Domain.mappingDomain.toDomain
import com.example.helpai.data.DataSourse.ChatMessageEntity
import com.example.helpai.data.DataSourse.Dao
import com.example.helpai.data.DataSourse.RetrofitGet
import com.google.gson.GsonBuilder
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RepositoryData @Inject constructor(
    private val chatDao: Dao,
    private val retrofitGet: RetrofitGet
) : Data {
    override val chatFlow: Flow<List<ModelsDomain>> =
        chatDao.getAllListChat()
            .map { list ->
                list.map { entity ->
                    entity.toDomain()
                }
            }

    override suspend fun sendMessage(text: String) {

        retrofitGet.getResponse(text)

    }

//    override suspend fun getRespons(getText: String): Flow<List<ModelsDomain>> {
//        return flow {
//            Log.d("RepositoryData", "Raw response: ${response.candidatesRespons}")
//
//            val parts = response.candidatesRespons?.firstOrNull()?.content?.parts
//
//            if (parts != null) {
//                val firstText = parts.firstOrNull()?.text
//
//                Log.d("GeminiResponse", firstText ?: "No text found")
//
//                emit(parts?.map { it.toDomain() } ?: emptyList())
//
//            }
//
//            Log.d("GeminiResponse", "Parsed response: ${parts?.map { it.toDomain() }}")
//        }
//    }

}




