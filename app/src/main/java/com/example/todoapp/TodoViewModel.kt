import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.TodoData
import com.example.todoapp.TodoManager

class TodoViewModel : ViewModel() {

    private var _todoList = MutableLiveData<List<TodoData>>()
    val todoList: LiveData<List<TodoData>> = _todoList

    init {
        getAllTodo()
    }

    fun getAllTodo() {
        _todoList.value = TodoManager.getAllTodo().reversed()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun addTodo(title: String) {
        TodoManager.addTodo(title)
        getAllTodo()
    }

    fun updateTodoTitle(id: Int, title: String) {
        val updatedList = _todoList.value.orEmpty().map {
            if (it.id == id) {
                it.copy(title = title) // Update title of the matching todo item
            } else {
                it
            }
        }
        _todoList.value = updatedList
        TodoManager.updateTodo(id, title)
    }

    fun deleteTodo(id: Int) {
        TodoManager.deleteTodo(id)
        getAllTodo()
    }
}
