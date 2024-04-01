package com.info.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.info.todo.NoteViewModelFactory
import com.info.todo.TodoRepo
import com.info.todo.databinding.ActivityMainBinding
import com.info.todo.utils.shortToast
import com.info.todo.viewmodels.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        try {
            val repo = TodoRepo()
            val noteViewModelProviderFactory = NoteViewModelFactory(repo)
            viewModel = ViewModelProvider(
                this,
                noteViewModelProviderFactory
            )[MainViewModel::class.java]


        } catch (e: Exception) {
            shortToast("Error")

        }


    }
}