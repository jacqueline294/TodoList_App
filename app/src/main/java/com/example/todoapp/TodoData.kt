package com.example.todoapp

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date

data class TodoData(
    var id: Int,
    var title: String,
    var createdAt: Date
)
@RequiresApi(Build.VERSION_CODES.O)
fun getTodoData(): List<TodoData> {
    return listOf<TodoData>(
        TodoData(1,"First todo ",Date.from(Instant.now())),
        TodoData(2,"Second todo ",Date.from(Instant.now())),
        TodoData(3,"this is my third todo ",Date.from(Instant.now())),
        TodoData(4,"this will be my forth todo so that i can use it in UI ",Date.from(Instant.now()))
    );
}
