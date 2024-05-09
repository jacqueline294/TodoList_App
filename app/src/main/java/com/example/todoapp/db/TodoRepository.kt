package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import com.example.todoapp.db.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.Instant
import java.util.Date

class TodoRepository(private val todoDao: TodoDao) {

    val todoList: LiveData<List<Todo>> = todoDao.getAll()

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun addTodo(title: String): Long {
        return withContext(Dispatchers.IO) {
            val todo = Todo(title = title, createdAt = Date.from(Instant.now()))
            todoDao.add(todo)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun updateTodoTitle(id: Int, title: String): Int {
        return withContext(Dispatchers.IO) {
            val todo = Todo(id = id, title = title, createdAt = Date.from(Instant.now()))
            todoDao.update(todo)
        }
    }

    suspend fun deleteTodo(id: Int) {
        withContext(Dispatchers.IO) {
            todoDao.deleteById(id)
        }
    }
}
