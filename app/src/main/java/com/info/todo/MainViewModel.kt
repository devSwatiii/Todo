package com.info.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.info.todo.local.TodoList
//import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
//import javax.inject.Inject

//@HiltViewModel
class MainViewModel (private val repo: TodoRepo) : ViewModel() {
    fun allTodoList() :List<TodoList>{
        var list :List<TodoList> = emptyList()
        viewModelScope.launch {
           list =  repo.allList()
        }
        return list
    }

    fun addTodoList(todoList: TodoList) {
        viewModelScope.launch {
            repo.insertData(todoList)
        }
    }
    fun findtile(todoList: String) {
        viewModelScope.launch {
            repo.findTitle(todoList)
        }
    }
    fun deleteTodoList(todoList: TodoList) {
        viewModelScope.launch {
            repo.deleteData(todoList)
        }
    }


}