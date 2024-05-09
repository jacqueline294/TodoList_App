package com.example.todoapp.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.Todo

@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun getAllTodo(): LiveData<List<Todo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(todo: Todo)

    @Query("DELETE FROM todo WHERE id = :id")
    suspend fun deleteById(id: Int)


    @Update
    suspend fun update(todo: Todo)
}
