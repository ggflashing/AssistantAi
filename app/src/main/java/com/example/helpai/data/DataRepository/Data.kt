package com.example.helpai.data.DataRepository

import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.data.DataSourse.ChatMessageEntity
import kotlinx.coroutines.flow.Flow

interface Data {
    val chatFlow: Flow<List<ModelsDomain>>

    suspend fun sendMessage(text: String)

}