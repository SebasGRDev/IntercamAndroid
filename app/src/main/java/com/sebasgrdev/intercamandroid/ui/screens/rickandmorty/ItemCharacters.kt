package com.sebasgrdev.intercamandroid.ui.screens.rickandmorty

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.sebasgrdev.intercamandroid.model.data.response.Result
import com.sebasgrdev.intercamandroid.ui.screens.rickandmorty.model.CharacterModel

@Composable
fun ItemCharacters(characters: CharacterModel) {
    var show by remember {
        mutableStateOf(false)
    }
    val colorStatus = when(characters.status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Gray
    }
    Card(
        onClick = { show = !show },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Black, contentColor = Color.White),
        border = BorderStroke(2.dp, color = Color.Green)
    ) {
        ConstraintLayout(
            Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            val (image, textContent, button) = createRefs()
            AsyncImage(
                model = characters.image,
                contentDescription = "Imagen del personaje",
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .size(80.dp)
                    .border(4.dp, colorStatus, CircleShape)
                    .clip(shape = CircleShape)
                    .constrainAs(image) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(vertical = 8.dp, horizontal = 16.dp)
                    .constrainAs(textContent) {
                        start.linkTo(image.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    },
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = characters.name,
                    textAlign = TextAlign.Start,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Status: ${characters.status}",
                    textAlign = TextAlign.Start,
                    fontSize = 16.sp
                )
            }
            IconButton(onClick = { }, modifier = Modifier.constrainAs(button) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowRight,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
            }
        }
    }
    AlertInfoCharacter(show = show, characters = characters, onDismiss = { show = false })
}
