package com.sebasgrdev.intercamandroid.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sebasgrdev.intercamandroid.ui.screens.autoriza3.ScreenIAutoriza
import com.sebasgrdev.intercamandroid.ui.screens.rickandmorty.ScreenRickAndMorty

@Composable
fun NavigationComponent(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(navController = navController, startDestination = "screen_main") {
        composable("screen_main") { ScreenIAutoriza(modifier = Modifier.padding(innerPadding), navController = navController) }
        composable("rickAndMortyScreen") { ScreenRickAndMorty(modifier = Modifier.padding(innerPadding), navController = navController) }
    }
}
