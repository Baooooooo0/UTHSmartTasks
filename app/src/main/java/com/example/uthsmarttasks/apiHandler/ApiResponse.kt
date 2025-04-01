package com.example.uthsmarttasks.apiHandler

data class ApiResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: List<Task>
)

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val status: String
)

data class TaskDetailResponse(
    val isSuccess: Boolean,
    val message: String,
    val data: TaskDetail
)

data class TaskDetail(
    val id: Int,
    val title: String,
    val desImageURL: String,
    val description: String,
    val status: String,
    val priority: String,
    val category: String,
    val subtasks: List<Subtask>,
    val attachments: List<Attachment>
)

data class Subtask(
    val id: Int,
    val title: String,
    val isCompleted: Boolean
)

data class Attachment(
    val id: Int,
    val fileName: String,
    val fileUrl: String
)