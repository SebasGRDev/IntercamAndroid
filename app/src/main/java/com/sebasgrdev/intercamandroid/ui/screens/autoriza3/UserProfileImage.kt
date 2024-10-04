package com.sebasgrdev.intercamandroid.ui.screens.autoriza3

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sebasgrdev.intercamandroid.R


@Composable
fun EditImageProfile(modifier: Modifier, onImageSelected: (Uri) -> Unit) {
    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let { onImageSelected(it) }
    }

    IconButton(onClick = {
        launcher.launch("image/*")
    }, modifier = modifier.padding(top = 24.dp)) {
        Icon(
            painter = painterResource(R.drawable.lapiz),
            contentDescription = "Icono editar foto",
            tint = Color.White,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Composable
fun UserProfileImage(modifier: Modifier, imageUri: Uri?) {
    Card(
        modifier = modifier
            .padding(top = 24.dp)
            .border(4.dp, Color.White, CircleShape)
            .clip(shape = CircleShape)
    ) {
        if (imageUri != null) {
            AsyncImage(
                model = imageUri,
                contentDescription = "Foto de perfil",
                modifier = modifier
                    .size(90.dp)
                    .border(4.dp, Color.White, CircleShape)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )
        } else {
            Image(
                painter = painterResource(R.drawable.logo_profile),
                contentDescription = "Foto de perfil",
                modifier = modifier
                    .size(90.dp)
                    .border(4.dp, Color.White, CircleShape)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }

}