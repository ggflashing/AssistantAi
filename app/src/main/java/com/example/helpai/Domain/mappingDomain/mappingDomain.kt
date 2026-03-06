package com.example.helpai.Domain.mappingDomain

import com.example.helpai.ConnectApi.ModelResponse.TextRespons
import com.example.helpai.Domain.DomainModels.ModelsDomain
import com.example.helpai.data.DataSourse.ChatMessageEntity


fun ChatMessageEntity.toDomain(): ModelsDomain {

    return ModelsDomain(
        text = text,
        role = role,
        timestamp = timestamp
    )

}