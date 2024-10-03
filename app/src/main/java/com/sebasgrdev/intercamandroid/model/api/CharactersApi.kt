package com.sebasgrdev.intercamandroid.model.api

import com.sebasgrdev.intercamandroid.model.data.response.CharactersResponse
import com.sebasgrdev.intercamandroid.model.data.response.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersApi {

    @GET("character/")
    suspend fun getAllCharacters(@Query("page") page: Int): CharactersResponse
}