package com.info.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.info.todo.MainViewModel
import com.info.todo.R
import com.info.todo.databinding.FragmentAddBinding
import com.info.todo.local.TodoList

//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class AddFragment : Fragment() {
    lateinit var viewModel: MainViewModel
    lateinit var binding: FragmentAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            MainViewModel::class.java
        )

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onStart() {
        super.onStart()
        binding.submitBtn?.setOnClickListener {

            viewModel.addTodoList(
//                if(binding.etDes.text?.isNotEmpty() == true && binding.etDes.text?.isNotEmpty()!! && binding.etDes.text?.isNotEmpty() == true){
                    TodoList(
                        description = binding.etDes.text.toString(),
                        title = binding.etTitle.text.toString(),
                        priority = binding.etPri.text.toString().toInt()
                    ))
                }

//            )
        }


}