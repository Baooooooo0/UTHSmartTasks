package com.example.uthsmarttasks.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.uthsmarttasks.R
import com.example.uthsmarttasks.recycle.Footer
import com.example.uthsmarttasks.recycle.Header


@Composable
fun FirstScreen(navController: NavHostController) {
    Column {
        Header(1, navController)
        Box(
            modifier = Modifier
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.screen1),
                    contentDescription = "Centered Image",
                    modifier = Modifier
                        .size(400.dp)
                        .padding(25.dp)
                )
                Text(
                    text = "Easy Time Management",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first ",
                    fontSize = 20.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(25.dp)
                )
            }
        }
        Footer(navController = navController, "second", "Next", showBackButton = false)
    }
}