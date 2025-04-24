package com.example.uthsmarttasks.recycle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable

fun Footer(navController: NavController, route: String, textButton1: String, showBackButton: Boolean){
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(0.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (showBackButton){
            ButtonBack(navController = navController)
        }
        ButtonScreen(navController = navController, route, textButton1)
    }
}