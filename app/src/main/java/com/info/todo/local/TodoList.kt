package com.info.todo.local

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TodoList(
     @PrimaryKey(autoGenerate = true) val id :Int = 0,
    val description:String,
    val title:String,
    val priority:Int
)
