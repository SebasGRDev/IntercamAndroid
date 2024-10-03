package com.sebasgrdev.intercamandroid.model.data.response

import androidx.compose.animation.core.rememberInfiniteTransition
import com.sebasgrdev.intercamandroid.ui.screens.rickandmorty.model.CharacterModel

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
) {
    fun toModel(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            gender = gender,
            image = image,
            status = status,
            species = species
        )
    }
}