package com.example.uthsmarttasks.ui.screens.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.uthsmarttasks.apiHandler.RetrofitInstance
import com.example.uthsmarttasks.apiHandler.Task
import com.example.uthsmarttasks.apiHandler.TaskDetail
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TaskViewModel : ViewModel() {
    private val _tasks = mutableStateOf<List<Task>>(emptyList()) // Dữ liệu API
    val tasks: State<List<Task>> = _tasks

    private val _taskDetail = MutableStateFlow<TaskDetail?>(null)
    val taskDetail: StateFlow<TaskDetail?> = _taskDetail

    init {
        fetchTasks()
    }

    private fun fetchTasks() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTasks()
                if (response.isSuccess) {
                    _tasks.value = response.data
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun fetchTaskDetail(id: Int) {
        viewModelScope.launch {
            try {
                Log.d("API_CALL", "Fetching task with ID: $id")

                val response = RetrofitInstance.api.getTaskDetail(id)
                if (response.isSuccess) {
                    _taskDetail.value = response.data

                    // In API ra Logcat
                    Log.d("API_RESPONSE", "Title: ${response.data.title}")
                    Log.d("API_RESPONSE", "Description: ${response.data.description}")
                    Log.d("API_RESPONSE", "Category: ${response.data.category}")
                    Log.d("API_RESPONSE", "Status: ${response.data.status}")
                    Log.d("API_RESPONSE", "Priority: ${response.data.priority}")
                    Log.d("API_CALL", "ID: $id")

                    response.data.subtasks.forEach { subtask ->
                        Log.d("API_RESPONSE", "Subtask: ${subtask.title} - Completed: ${subtask.isCompleted}")
                    }

                    response.data.attachments.forEach { attachment ->
                        Log.d("API_RESPONSE", "Attachment: ${attachment.fileName} - URL: ${attachment.fileUrl}")
                    }

                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Lỗi khi gọi API: ${e.message}")
            }
        }
    }
}

