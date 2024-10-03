package com.sebasgrdev.intercamandroid.ui.screens.rickandmorty.model

import com.sebasgrdev.intercamandroid.model.data.response.Location
import com.sebasgrdev.intercamandroid.model.data.response.Origin

data class CharacterModel (
    val gender: String,
    val id: Int,
    val image: String,
    val name: String,
    val species: String,
    val status: String,
)