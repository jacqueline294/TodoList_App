package com.example.todoapp

import com.example.todoapp.db.TodoRepository
import com.example.todoapp.TodoViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.db.TodoDatabase
import com.example.todoapp.ui.theme.TodoAppTheme
import exacom.example.todoapp.TodoListPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize MainApplication to set up TodoDatabase
        MainApplication.todoDatabase = TodoDatabase.getInstance(applicationContext)

        val todoDao = MainApplication.todoDatabase.todoDao()
        val todoRepository = TodoRepository(todoDao)
        val todoViewModelFactory = TodoViewModelFactory(todoRepository)
        val todoViewModel = ViewModelProvider(this, todoViewModelFactory)
            .get(TodoViewModel::class.java)

        enableEdgeToEdge()

        setContent {
            TodoAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoListPage(todoViewModel)
                }
            }
        }
    }
}
