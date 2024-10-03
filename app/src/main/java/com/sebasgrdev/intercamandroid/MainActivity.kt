package com.sebasgrdev.intercamandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.sebasgrdev.intercamandroid.ui.screens.autoriza3.ScreenIAutoriza
import com.sebasgrdev.intercamandroid.ui.theme.IntercamAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IntercamAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ScreenIAutoriza(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}