package com.sebasgrdev.intercamandroid.ui.screens.autoriza3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sebasgrdev.intercamandroid.R
import com.sebasgrdev.intercamandroid.model.data.Payment
import com.sebasgrdev.intercamandroid.ui.theme.Green
import com.sebasgrdev.intercamandroid.viewmodel.PaymentViewModel

@Composable
fun PaymentList(modifier: Modifier, viewModel: PaymentViewModel = viewModel()) {

    val payment = viewModel.paymentList

    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Autorizaste", fontSize = 14.sp, textAlign = TextAlign.End, fontWeight = FontWeight.ExtraBold, modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp))
        LazyColumn() {
            items(payment) {
                ItemPayment(it)
            }
        }
    }

}

@Composable
fun ItemPayment(payment: Payment) {
    val paymentTypeIcons = mapOf(
        "Cambio de Estatus" to R.drawable.ico_ce,
        "Remesas" to R.drawable.ico_remesas,
        "Remesas Mayores" to R.drawable.ico_remsa_may,
        "Canjes" to R.drawable.group_4,
        "Pago por Anticipado" to R.drawable.campana
    )

    val iconResId = paymentTypeIcons[payment.operation_type] ?: R.drawable.ico_ce

    Column(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp))
    {

        ConstraintLayout(Modifier.fillMaxSize()) {

            val (operationType, totalOperationAuth, totalOperation,iconOperation) = createRefs()

            Icon(painter = painterResource(id = iconResId), contentDescription = "Cambio de estatus", tint = Green, modifier = Modifier
                .padding(8.dp)
                .size(48.dp)
                .constrainAs(iconOperation) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                })

            Text(text = payment.total_operation.toString(), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold, modifier = Modifier.constrainAs(totalOperation){
                start.linkTo(operationType.start)
                top.linkTo(parent.top)
                bottom.linkTo(operationType.top)

            })

            Text(text = payment.operation_type, fontSize = 16.sp, color = Green, fontWeight = FontWeight.Bold, modifier = Modifier.constrainAs(operationType){
                start.linkTo(iconOperation.end, margin = 8.dp)
                top.linkTo(totalOperation.bottom)
                bottom.linkTo(parent.bottom)

            })

            Text(
                text = payment.total_operation_auth.toString(),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .constrainAs(totalOperationAuth) {
                        end.linkTo(parent.end, margin = 16.dp)
                        top.linkTo(operationType.top) // centrado vertical
                        bottom.linkTo(operationType.bottom)
                    }
            )

            HorizontalDivider(Modifier.height(2.dp))

        }
    }
}

@Composable
fun OperationType(modifier: Modifier, payment: Payment) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = payment.total_operation.toString(), fontSize = 18.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = payment.operation_type, fontSize = 16.sp, color = Green, fontWeight = FontWeight.Bold)
    }
}
