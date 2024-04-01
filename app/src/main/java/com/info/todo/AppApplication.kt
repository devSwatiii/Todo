package com.info.todo

import android.app.Application
import androidx.room.Room
import com.info.todo.local.TodoDataBase


class AppApplication: Application() {
    companion object{
    lateinit var database: TodoDataBase
}
    override fun onCreate() {
        super.onCreate()

        database = Room.databaseBuilder(
            applicationContext,
            TodoDataBase::class.java,
            "todo_database"
        ).build()
    }
    }


