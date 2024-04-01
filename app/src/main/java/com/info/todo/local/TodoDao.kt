package com.info.todo.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update



@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(todo:TodoList)

    @Update
    suspend fun update(todo: TodoList)

    @Delete
    suspend fun delete(todo: TodoList)

    @Query("SELECT * FROM TodoList WHERE title LIKE :query OR priority LIKE :query ORDER BY id DESC")
    fun searchNote(query: String): LiveData<List<TodoList>>

    @Query("Select * from TodoList")
     fun allList():LiveData<List<TodoList>>

}