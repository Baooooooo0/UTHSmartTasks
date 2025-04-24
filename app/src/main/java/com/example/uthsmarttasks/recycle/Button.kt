package com.example.uthsmarttasks.recycle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable

fun ButtonScreen(navController: NavController, route: String, textButton1: String){
    Box(
        modifier = Modifier
            .background(Color.White)
    ){
        Button(
            onClick = {navController.navigate(route) },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF42AFFF),
                contentColor = Color.White
            ),
            modifier = Modifier
                .padding(bottom = 37.dp, end = 25.dp, top = 160.dp, start = 25.dp)
                .width(550.dp)
                .height(60.dp)
                .align(Alignment.BottomEnd)
        ) {
            Text(
                text = textButton1,
                fontSize = 25.sp
            )
        }
    }
}