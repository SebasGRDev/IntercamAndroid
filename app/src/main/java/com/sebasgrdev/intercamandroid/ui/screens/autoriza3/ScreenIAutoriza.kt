package com.sebasgrdev.intercamandroid.ui.screens.autoriza3

import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.constraintlayout.compose.ConstraintLayout

@RequiresApi(Build.VERSION_CODES.N)
@Preview
@Composable
fun ScreenIAutoriza(modifier: Modifier = Modifier) {

    var selectedImageUri by remember { mutableStateOf<Uri?>(null) }

    ConstraintLayout(modifier.fillMaxSize()) {
        val (topBarUser, userProfileImage, noticePendingInfo, paymentList, supportButton, editPhoto) = createRefs()


        TopBarUserInfo(modifier.constrainAs(topBarUser) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(noticePendingInfo.top)
        })
        UserProfileImage(modifier = Modifier.constrainAs(userProfileImage) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(topBarUser.top)
            bottom.linkTo(noticePendingInfo.bottom)
        }, imageUri = selectedImageUri)
        EditImageProfile(modifier = Modifier.constrainAs(editPhoto) {
            top.linkTo(userProfileImage.top)
            start.linkTo(userProfileImage.end)
        }, onImageSelected = { uri -> selectedImageUri = uri })
        NoticePendingInfo(Modifier.constrainAs(noticePendingInfo) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(topBarUser.bottom)
            bottom.linkTo(paymentList.top)
        })
        PaymentList(Modifier.constrainAs(paymentList) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(noticePendingInfo.bottom)
            bottom.linkTo(supportButton.top)
        })
        SupportButton(Modifier.constrainAs(supportButton) {
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            top.linkTo(paymentList.bottom)
            bottom.linkTo(parent.bottom)
        })
    }
}




