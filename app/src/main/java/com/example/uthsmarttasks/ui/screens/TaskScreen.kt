package com.example.uthsmarttasks.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.uthsmarttasks.MenuFooter
import com.example.uthsmarttasks.MenuHeader
import com.example.uthsmarttasks.apiHandler.Task
import com.example.uthsmarttasks.apiHandler.TaskViewModel

@Composable
fun TaskScreen(navController: NavController, viewModel: TaskViewModel = viewModel()) {
    val tasks by viewModel.tasks

    Column(modifier = Modifier.fillMaxWidth().padding(start = 15.dp, top = 35.dp ,end = 15.dp, bottom = 100.dp)) {
        MenuHeader()
//        LazyColumn {
//            items(tasks) { task ->
//                TaskButton(task, navController)
//            }
//        }
        MenuFooter()
    }
}

@Composable
fun TaskButton(task: Task, navController: NavController) {
    Button(
        onClick = { navController.navigate("taskDetail/${task.id}") },
        shape = RoundedCornerShape(25),
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(text = task.title, style = MaterialTheme.typography.titleMedium)
            Text(text = task.description, style = MaterialTheme.typography.titleMedium)
            Text(text = "Status: ${task.status}", style = MaterialTheme.typography.labelSmall)
        }
    }
}
