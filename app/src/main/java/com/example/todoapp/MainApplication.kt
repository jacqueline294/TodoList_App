package com.example.todoapp



import android.app.Application
import androidx.room.Room
import com.example.todoapp.db.TodoDatabase

class MainApplication : Application() {

    companion object {
        lateinit var todoDatabase: TodoDatabase
    }

    override fun onCreate() {
        super.onCreate()
        todoDatabase = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            "todo_database" // Make sure this matches the database name in TodoDatabase
        ).build() // Call build() to create the database instance
    }
}
