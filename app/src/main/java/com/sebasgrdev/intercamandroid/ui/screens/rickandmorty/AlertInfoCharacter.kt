package com.sebasgrdev.intercamandroid.ui.screens.rickandmorty

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import coil.compose.AsyncImage
import com.sebasgrdev.intercamandroid.model.data.Result
import com.sebasgrdev.intercamandroid.ui.theme.Green

@Composable
fun AlertInfoCharacter(characters: Result, show: Boolean, onDismiss: () -> Unit) {
    if (show) {
        Dialog(onDismissRequest = { onDismiss() }) {
            val colorStatus = when(characters.status) {
                "Alive" -> Color.Green
                "Dead" -> Color.Red
                else -> Color.Gray
            }
            Card(
                modifier = Modifier.background(
                    Brush.linearGradient(
                        colors = listOf(Color.Black, Green),
                        start = Offset(0f, 0f),
                        end = Offset(1000f, 1000f)
                    ),
                ), border = BorderStroke(2.dp, colorStatus),
                colors = CardDefaults.cardColors(containerColor = Color.Transparent)
            ) {
                TitleName(characters.name)
                Row(Modifier.fillMaxWidth().padding(16.dp)) {
                    ImageCharacter(image = characters.image, status = characters.status)
                    Column(Modifier.padding(horizontal = 16.dp)) {
                        TextId(characters.id)
                        TextStatus(characters.status)
                        TextSpecies(characters.species)
                        TextGender(characters.gender)
                    }
                }
            }
        }
    }

}

@Composable
fun ImageCharacter(image: String, status: String) {
    val colorStatus = when(status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Gray
    }
    AsyncImage(
        model = image,
        contentDescription = "Imagen del personaje",
        modifier = Modifier
            .size(100.dp)
            .border(4.dp, colorStatus),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun TextGender(gender: String) {
    Text(
        text = "Gender: $gender",
        fontSize = 16.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextSpecies(species: String) {
    Text(
        text = "Species: $species",
        fontSize = 16.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextStatus(status: String) {
    Text(
        text = "Status: $status",
        fontSize = 16.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}

@Composable
fun TextId(id: Int) {
    Text(
        text = "Id: ${id.toString()}",
        fontSize = 16.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Start
    )
}

@Composable
fun TitleName(name: String) {
    Text(
        text = name,
        fontSize = 24.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
        textAlign = TextAlign.Center
    )
}