package com.sebasgrdev.intercamandroid.model.api

import com.sebasgrdev.intercamandroid.model.data.CharactersResponse
import com.sebasgrdev.intercamandroid.model.data.Result
import retrofit2.http.GET

interface CharactersApi {

    @GET("character")
    suspend fun getAllCharacters() : CharactersResponse
}