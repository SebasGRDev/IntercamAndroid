package com.sebasgrdev.intercamandroid.model.api

import com.sebasgrdev.intercamandroid.model.data.CharactersResponse
import com.sebasgrdev.intercamandroid.model.data.Result
import javax.inject.Inject

class CharactersRepository @Inject constructor (private val api: CharactersApi) {
    suspend fun getAllCharacters(): CharactersResponse {
        return api.getAllCharacters()
    }
}