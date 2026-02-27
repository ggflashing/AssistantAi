package com.example.helpai.data.DataRepository

import com.example.helpai.Domain.DomainModels.ModelsDomain
import kotlinx.coroutines.flow.Flow

interface Data {

    suspend fun getRespons(getText: String): Flow<List<ModelsDomain>>

}