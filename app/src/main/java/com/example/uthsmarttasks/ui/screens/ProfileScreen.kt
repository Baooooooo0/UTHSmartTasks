package com.example.uthsmarttasks.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import com.example.uthsmarttasks.Footer
import com.example.uthsmarttasks.R

@Composable
fun HeaderProfile(navHostController: NavHostController, detail: String){
    Column(
        modifier = Modifier.background(Color.White)
    ) {
        Box {
            Button(
                onClick = {navHostController.popBackStack()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White,
                    contentColor = Color(0xFF42AFFF)
                ),
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 40.dp, start = 5.dp, end = 15.dp, bottom = 15.dp)
            )
            {
                Text(
                    text = "<",
                    fontSize = 40.sp
                )
            }
            Text(
                text = detail,
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF42AFFF),
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp, top = 55.dp)
            )
        }
    }
}



@Composable
fun ProfileScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            HeaderProfile(navHostController = navController, detail = "Profile")
        }

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 120.dp)
                .background(color = Color.White)
        ) {
            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = "LoginImage",
                modifier = Modifier
                    .size(230.dp)
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 5.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Footer(
            navController = navController,
            route = "authScreen",
            textButton1 = "Back",
            showBackButton = false
            )
        }
    }
}