package com.example.todoapp.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo")
    fun getAll(): List<Todo>

    @Insert
    fun add(todo: Todo)

    @Update
    fun update(todo: Todo): Int

    @Delete
    fun delete(todo: Todo)
}
