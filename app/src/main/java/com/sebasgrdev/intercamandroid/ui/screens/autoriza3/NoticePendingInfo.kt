package com.sebasgrdev.intercamandroid.ui.screens.autoriza3

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.sebasgrdev.intercamandroid.R
import com.sebasgrdev.intercamandroid.ui.theme.Green
import com.sebasgrdev.intercamandroid.utils.DateUtils.getFormattedDate

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun NoticePendingInfo(modifier: Modifier) {
    ConstraintLayout(modifier = modifier.fillMaxWidth()) {
        val (infoText, filterButton) = createRefs()
        InfoText(modifier = Modifier.constrainAs(infoText) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(filterButton.top)
        })
        FilterButton(modifier = Modifier.constrainAs(filterButton) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        })
    }
}

@Composable
fun FilterButton(modifier: Modifier) {
    Button(
        onClick = {},
        modifier = modifier.padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Green, contentColor = Color.White)
    ) {
        Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(painter = painterResource(R.drawable.searchfilter), contentDescription = "Filtro de búsqueda", Modifier.size(16.dp))
            Spacer(Modifier.width(8.dp))
            Text(text = "Filtro de búsqueda")
        }

    }
}

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun InfoText(modifier: Modifier) {
    val formattedDate = getFormattedDate()

    Column(modifier = modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
        Text(text = formattedDate, fontSize = 16.sp)
        Text(text = "Tienes pagos por autorizar:", fontSize = 16.sp, fontWeight = FontWeight.ExtraBold)
    }
}
