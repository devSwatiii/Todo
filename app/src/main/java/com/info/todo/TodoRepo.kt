package com.info.todo

import com.info.todo.AppApplication.Companion.database
import com.info.todo.local.TodoList

class TodoRepo () {
     fun allList() = database.todoDao().allList()
     fun findPriority(query: String) = database.todoDao().searchNote(query)


    suspend fun insertData(todoList: TodoList){
       
        database.todoDao().add(todoList)
    }
    suspend fun deleteData(todoList: TodoList){
        database.todoDao().delete(todoList)
    }
    suspend fun updateData(todoList: TodoList){
        database.todoDao().update(todoList)
    }

}