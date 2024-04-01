package com.info.todo

import com.info.todo.local.TodoDao
import com.info.todo.local.TodoList

class TodoRepo (private val dao: TodoDao) {
    suspend fun allList():List<TodoList>{
        return dao.allList()
    }


    suspend fun insertData(todoList: TodoList){
        dao.add(todoList)
    }
    suspend fun deleteData(todoList: TodoList){
        dao.delete(todoList)
    }
    suspend fun updateData(todoList: TodoList){
        dao.update(todoList)
    }
    suspend fun findTitle(todoList: String){
        dao.findByTitle(todoList)
    }
}