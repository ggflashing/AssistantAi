package com.example.helpai.Domain.UseCase

import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.Domain.DomainModels.RequstAndRespons
import com.example.helpai.data.DataRepository.RepositoryData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LogicUse @Inject constructor(

    private val repositoryData: RepositoryData
): PrivatCase {


    override suspend fun getResponsUse(textUse: String): Flow<RequstAndRespons> {
        return repositoryData.getRespons(getText = textUse)
            .map { requstandrespons->
                RequstAndRespons(
                    Requst = textUse,
                    respons = requstandrespons
                )
                
            }
    }


}