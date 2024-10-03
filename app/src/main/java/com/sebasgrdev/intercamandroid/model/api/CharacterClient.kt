package com.sebasgrdev.intercamandroid.model.api

import com.sebasgrdev.intercamandroid.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CharacterClient {


    fun provideApi(): CharactersApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CharactersApi::class.java)
    }
}