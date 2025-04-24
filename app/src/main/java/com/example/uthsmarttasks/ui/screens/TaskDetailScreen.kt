package com.example.uthsmarttasks.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.uthsmarttasks.ui.screens.viewmodel.TaskViewModel

@Composable
fun TaskDetailScreen(taskId: Int, viewModel: TaskViewModel = viewModel()) {
    val taskDetail by viewModel.taskDetail.collectAsState()

    LaunchedEffect(taskId) {
        viewModel.fetchTaskDetail(taskId)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        taskDetail?.let { task ->
            Text(text = task.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Description ${task.description}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Category: ${task.category}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Priority: ${task.priority}", style = MaterialTheme.typography.bodyLarge)
            Text(text = "Status: ${task.status}", style = MaterialTheme.typography.bodyLarge)


            Text(text = "Subtasks:", style = MaterialTheme.typography.headlineSmall)
            LazyColumn {
                items(task.subtasks) { subtask ->
                    Text(text = "- ${subtask.title} (${if (subtask.isCompleted) "✅" else "❌"})")
                }
            }

            Text(text = "Attachments:", style = MaterialTheme.typography.headlineSmall)
            LazyColumn {
                items(task.attachments) { attachment ->
                    Text(text = "- ${attachment.fileName}: ${attachment.fileUrl}")
                }
            }

        } ?: CircularProgressIndicator() // Hiển thị loading khi API chưa tải xong
    }
}
