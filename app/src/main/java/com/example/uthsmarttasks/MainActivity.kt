package com.example.uthsmarttasks

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = FirebaseFirestore.getInstance()
        db.collection("test")
            .get()
            .addOnSuccessListener {
                Log.d("FirebaseTest", "Firestore kết nối thành công!")
            }
            .addOnFailureListener {
                Log.e("FirebaseTest", "Firestore lỗi: ${it.message}")
            }
        enableEdgeToEdge()
        setContent {
            AppNavigation()
        }
    }
}















//        Log.d("API_DEBUG", "Starting API Call...") // Thêm log kiểm tra
//
//        lifecycleScope.launch {
//            try {
//                val response = RetrofitInstance.api.getTasks()
//                if (response.isSuccess) {
//                    response.data.forEach { task ->
//                        Log.d("API_TASK", "Title: ${task.title}, Description: ${task.description}, Status: ${task.status}")
//                    }
//                } else {
//                    Log.e("API_ERROR", "Failed to fetch tasks: ${response.message}")
//                }
//            } catch (e: Exception) {
//                Log.e("API_EXCEPTION", "Error: ${e.message}")
//            }
//        }
//    }
//}

