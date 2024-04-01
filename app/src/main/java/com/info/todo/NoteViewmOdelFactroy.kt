package com.info.todo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.info.todo.viewmodels.MainViewModel

class NoteViewModelFactory(private val repo: TodoRepo) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }

}