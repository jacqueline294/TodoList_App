package com.example.todoapp.db

import androidx.lifecycle.LiveData
import com.example.todoapp.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.Date

class TodoRepository(private val todoDao: TodoDao) {

    val todoList: LiveData<List<Todo>> = todoDao.getAllTodo()

    suspend fun addTodo(title: String) {
        withContext(Dispatchers.IO) {
            val currentTime = System.currentTimeMillis()
            val todo = Todo(title = title, createdAt = Date())
            todoDao.add(todo)
        }
    }

    suspend fun updateTodoTitle(id: Int, title: String) {
        withContext(Dispatchers.IO) {
            val currentTime = System.currentTimeMillis()
            val todo = Todo(id = id, title = title, createdAt = Date())
            todoDao.update(todo)
        }
    }

    suspend fun deleteTodo(id: Int) {
        withContext(Dispatchers.IO) {
            todoDao.deleteById(id)
        }
    }
}
