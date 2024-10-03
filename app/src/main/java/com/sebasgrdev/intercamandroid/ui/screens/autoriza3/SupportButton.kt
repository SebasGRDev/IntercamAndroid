package com.sebasgrdev.intercamandroid.ui.screens.autoriza3

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebasgrdev.intercamandroid.R

@Composable
fun SupportButton(modifier: Modifier) {
    val context = LocalContext.current.applicationContext

    Row(modifier = modifier.fillMaxWidth().padding(8.dp), horizontalArrangement = Arrangement.End, verticalAlignment = Alignment.CenterVertically) {
        Text(text = "Soporte: ", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        IconButton(onClick = { Toast.makeText(context, "En proceso", Toast.LENGTH_LONG).show() }) {
            Icon(painter = painterResource(R.drawable.icn_support), contentDescription = "Botón Soporte", modifier = Modifier.size(24.dp), tint = Color.Unspecified)
        }
    }
}