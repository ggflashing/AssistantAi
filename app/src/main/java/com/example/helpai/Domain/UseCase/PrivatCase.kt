package com.example.helpai.Domain.UseCase

import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.data.DataSourse.ChatMessageEntity
import kotlinx.coroutines.flow.Flow

interface PrivatCase {

    val chatFlow: Flow<List<ModelsDomain>>
    suspend fun sendMessage(text: String): Flow<List<ModelsDomain>>

}