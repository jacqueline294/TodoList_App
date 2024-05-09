package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoViewModel(
    private val todoRepository: TodoRepository) : ViewModel() {

    val todoList: LiveData<List<Todo>> = todoRepository.todoList

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.addTodo(title)
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun updateTodoTitle(id: Int, title: String) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.updateTodoTitle(id, title)
        }
    }

    fun deleteTodo(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            todoRepository.deleteTodo(id)
        }
    }
}
