package com.example.helpai.Domain.UseCase

import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.data.DataRepository.RepositoryData
import com.example.helpai.data.DataSourse.ChatMessageEntity
import com.example.helpai.presentation.ScreenHomeAI.ChatMessage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LogicUse @Inject constructor(

    private val repositoryData: RepositoryData
): PrivatCase {

    override val chatFlow: Flow<List<ModelsDomain>>
            = repositoryData.chatFlow

    override suspend fun sendMessage(text: String): Flow<List<ModelsDomain>> = flow {
        repositoryData.sendMessage(text)

    }
//    override suspend fun getResponsUse(textUse: String): Flow<RequstAndRespons> {
//
//
//        return repositoryData.getRespons(getText = textUse)
//            .map { requstandrespons->
//                RequstAndRespons(
//                    Requst = textUse,
//                    respons = requstandrespons
//                )
//
//            }
//    }

}