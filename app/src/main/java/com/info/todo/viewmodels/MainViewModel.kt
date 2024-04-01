package com.info.todo.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.todo.TodoRepo
import com.info.todo.local.TodoList
import kotlinx.coroutines.launch

class MainViewModel (private val repo: TodoRepo) : ViewModel() {
     fun allTodoList() :LiveData<List<TodoList>>  = repo.allList()
     fun searchData(query: String) :LiveData<List<TodoList>>  = repo.findPriority(query)



    fun addTodoList(todoList: TodoList) {
        viewModelScope.launch {
            repo.insertData(todoList)
        }
    }

    fun deleteTodoList(todoList: TodoList) {
        viewModelScope.launch {
            repo.deleteData(todoList)
        }
    }


}