package com.example.uthsmarttasks

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable

fun Header(currentScreen: Int,navController: NavHostController){
    Row(
        modifier = Modifier.background(Color.White)
    ) {
        Box(
            modifier = Modifier
                .padding(top = 18.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { navController.navigate("TaskScreen")},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF42AFFF)
                ),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 23.dp)
            ) {
                Text(
                    text = "Skip",
                    fontSize = 25.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.padding(start = 16.dp, top = 40.dp, end = 12.dp)
            ) {
                for (i in 1..3) {
                    Box(
                        modifier = Modifier
                            .size(20.dp)
                            .padding(4.dp)
                            .background(
                                color = if (i == currentScreen) Color.Blue else Color.Gray.copy(0.3f),
                                shape = CircleShape
                        )
                    )
                }
            }
        }
    }
}