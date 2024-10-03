package com.sebasgrdev.intercamandroid.ui.screens.rickandmorty

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.sebasgrdev.intercamandroid.ui.theme.Green
import com.sebasgrdev.intercamandroid.viewmodel.CharactersViewModel

@Composable
fun ScreenRickAndMorty(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    val state = viewModel.characters.collectAsLazyPagingItems()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    colors = listOf(Green, Color.Black),
                    start = Offset(0f, 0f),
                    end = Offset(1000f, 1000f)
                )
            )
    ) {
        TopBar()
        LazyColumn {
            items(state.itemCount) {
                state[it]?.let { characterModel ->
                    ItemCharacters(characterModel)
                }
            }
        }
    }
}