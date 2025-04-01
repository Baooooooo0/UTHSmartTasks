package com.example.uthsmarttasks.apiHandler

import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("researchUTH/tasks")
    suspend fun getTasks(): ApiResponse

    @GET("researchUTH/task/{id}")
    suspend fun getTaskDetail(@Path("id") id: Int): TaskDetailResponse

}