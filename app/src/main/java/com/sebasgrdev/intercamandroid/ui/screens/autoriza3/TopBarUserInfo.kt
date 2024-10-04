package com.sebasgrdev.intercamandroid.ui.screens.autoriza3

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sebasgrdev.intercamandroid.R
import com.sebasgrdev.intercamandroid.ui.theme.Green

@Composable
fun TopBarUserInfo(modifier: Modifier) {
    ConstraintLayout(modifier = modifier
        .fillMaxWidth()
        .height(200.dp)
        .background(Green)
        .padding(8.dp)) {

        val (exitButton, welcomeText) = createRefs()

        ExitButton(modifier = Modifier.constrainAs(exitButton) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
        })
        WelcomeText(userName = "Carlos Medina López", modifier = Modifier.constrainAs(welcomeText) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
        })
    }
}

@Composable
fun ExitButton(modifier: Modifier) {
    var show by remember { mutableStateOf(false) }
    Button(onClick = { show = true }, modifier = modifier, colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)) {

        Text(text = "Salir ", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Light)
        Spacer(Modifier.width(8.dp))
        Icon(
            painter = painterResource(R.drawable.cerrar_sesion),
            contentDescription = "Cerrar sesión",
            Modifier.size(16.dp),
            tint = Color.White
        )
        ConfirmExitApp(show = show, onDismiss = {show = false}, onConfirm = { show = false })
    }
}

@Composable
fun ConfirmExitApp(show: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    val activity = (LocalContext.current as? Activity)
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            title = { Text(text = "Aviso", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center) },
            text = { Text(text = "¿Deseas salir de la aplicación?", textAlign = TextAlign.Center) },
            confirmButton = {
                TextButton(onClick = {
                    activity?.finish()
                }) {
                    Text(text = "Confirmar")
                }
            },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "Cancelar")
                }
            }
        )
    }
}

@Composable
fun WelcomeText(userName: String, modifier: Modifier) {
    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Bienvenido",
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(8.dp))
        Text(
            text = userName,
            color = Color.White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.ExtraBold
        )
    }
}