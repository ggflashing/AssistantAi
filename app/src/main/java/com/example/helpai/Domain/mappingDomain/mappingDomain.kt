package com.example.helpai.Domain.mappingDomain

import com.example.helpai.ConnectApi.ModelResponse.TextRespons
import com.example.helpai.Domain.DomainModels.ModelsDomain


fun TextRespons.toDomain(): ModelsDomain {

    return ModelsDomain(
        textDomain = this.text
    )

}