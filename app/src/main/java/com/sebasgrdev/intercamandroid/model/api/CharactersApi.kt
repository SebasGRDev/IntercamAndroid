package com.sebasgrdev.intercamandroid.model.api

import retrofit2.http.GET

interface CharactersApi {

    @GET
    suspend fun getAllCharacters()
}