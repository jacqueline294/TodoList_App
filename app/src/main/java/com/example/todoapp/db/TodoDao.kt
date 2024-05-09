package com.example.todoapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM Todo ORDER BY createdAt DESC")
    fun getAll(): LiveData<List<Todo>>

    @Insert
    fun add(todo: Todo): Long // Return type changed to Long to return the ID of the inserted row

    @Update
    fun update(todo: Todo): Int // Return type changed to Int to return the number of rows affected

    @Query("DELETE FROM Todo WHERE id = :id")
    fun deleteById(id: Int)
}
