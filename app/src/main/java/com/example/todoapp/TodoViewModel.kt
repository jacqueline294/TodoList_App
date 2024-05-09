package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.db.TodoRepository
import kotlinx.coroutines.launch
import com.example.todoapp.Todo



class TodoViewModel(private val repository: TodoRepository) : ViewModel() {
    val todoList: LiveData<List<Todo>> = repository.todoList

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        viewModelScope.launch {
            repository.addTodo(title)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateTodoTitle(id: Int, title: String) {
        viewModelScope.launch {
            repository.updateTodoTitle(id, title)
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch {
            repository.deleteTodo(id)
        }
    }
}
