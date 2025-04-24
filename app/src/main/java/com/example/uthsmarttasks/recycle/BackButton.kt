package com.example.uthsmarttasks.recycle

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uthsmarttasks.R

@Composable

fun ButtonBack(navController: NavController) {
    Box(
        modifier = Modifier
            .background(Color.White)
            .wrapContentSize()
    ){
        Image(
            contentDescription = "Back Button",
            painter = painterResource(id= R.drawable.backbutton),
            modifier = Modifier
                .padding(start = 5.dp,bottom = 37.dp, top = 160.dp)
                .size(85.dp)
                .align(Alignment.BottomStart)
                .clickable {
                    navController.popBackStack()
            }
        )
    }
}