package com.example.helpai.Domain.UseCase

import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.Domain.DomainModels.RequstAndRespons
import kotlinx.coroutines.flow.Flow

interface PrivatCase {

    suspend fun getResponsUse(textUse: String) : Flow<RequstAndRespons>

}