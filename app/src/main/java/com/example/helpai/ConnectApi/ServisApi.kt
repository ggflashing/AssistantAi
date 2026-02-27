package com.example.helpai.ConnectApi

import com.example.helpai.ConnectApi.ModelRequst.ContentRequst
import com.example.helpai.ConnectApi.ModelResponse.CandidatesResnponse
import com.example.helpai.ConnectApi.ModelResponse.Content
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface ServisApi {

    @POST("v1beta/models/gemini-2.5-flash:generateContent")
    suspend fun getContent(

        @Query ("key") Apikey : String,
        @Body responsPromt : ContentRequst

    ): CandidatesResnponse


}