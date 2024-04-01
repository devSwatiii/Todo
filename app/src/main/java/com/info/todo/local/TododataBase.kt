package com.info.todo.local

import androidx.room.Database
import androidx.room.RoomDatabase



@Database(entities = [TodoList::class], version = 1, exportSchema = false)
abstract class TodoDataBase :RoomDatabase() {


    abstract fun todoDao():TodoDao

}