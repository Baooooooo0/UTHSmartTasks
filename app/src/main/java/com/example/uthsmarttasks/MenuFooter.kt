package com.example.uthsmarttasks

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MenuFooter() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), // Take full height
        contentAlignment = Alignment.BottomCenter
    ) {
        Card(
            modifier = Modifier
                .width(3120.dp)
                .height(64.dp)
                .padding(bottom = 16.dp),
            shape = CardDefaults.elevatedShape,
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Home Icon
                IconButton(onClick = { /* Home navigation logic */ }) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = "Home",
                        tint = Color.Gray
                    )
                }

                // Calendar Icon
                IconButton(onClick = { /* Calendar navigation logic */ }) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = "Calendar",
                        tint = Color.Gray
                    )
                }

                // Add Button (Centered)
                Box(
                    modifier = Modifier.size(56.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = { /* Add action logic */ },
                        containerColor = Color.Blue,
                        contentColor = Color.White
                    ) {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = "Add"
                        )
                    }
                }

                // Document Icon
                IconButton(onClick = { /* Document navigation logic */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.List,
                        contentDescription = "Documents",
                        tint = Color.Gray
                    )
                }

                // Settings Icon
                IconButton(onClick = { /* Settings navigation logic */ }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = Color.Gray
                    )
                }
            }
        }
    }
}