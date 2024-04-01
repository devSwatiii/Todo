package com.info.todo.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.components.SingletonComponent


@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun add(todo:TodoList)

    @Update
    suspend fun update(todo: TodoList)

    @Delete
    suspend fun delete(todo: TodoList)

    @Query("Select * from TodoList Where title  = :title ")
    suspend fun findByTitle(title:String):List<TodoList>


    @Query("Select * from TodoList Where priority = :priority")
    suspend fun findByPriority(priority:Int):List<TodoList>

    @Query("Select * from TodoList")
    suspend fun allList():List<TodoList>

}