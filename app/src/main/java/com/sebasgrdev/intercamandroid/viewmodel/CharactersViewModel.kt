package com.sebasgrdev.intercamandroid.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sebasgrdev.intercamandroid.model.api.CharactersRepository
import com.sebasgrdev.intercamandroid.model.data.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val charactersRepo: CharactersRepository) : ViewModel() {

    private val _allCharacters = MutableStateFlow(emptyList<Result>())
    val allCharacters : StateFlow<List<Result>> = _allCharacters

    init {
        viewModelScope.launch {
            try {
                _allCharacters.value = charactersRepo.getAllCharacters().results
                Log.i("apiSucces", "$_allCharacters")
            } catch (e: Exception) {
                Log.e("apiError", "No data")
                // No internet D:
            }
        }
    }
}