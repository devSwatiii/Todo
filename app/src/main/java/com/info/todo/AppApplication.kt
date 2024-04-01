package com.info.todo

import android.app.Application
import androidx.room.Room
import com.info.todo.local.TodoDataBase

//import dagger.hilt.android.HiltAndroidApp

//@HiltAndroidApp
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


