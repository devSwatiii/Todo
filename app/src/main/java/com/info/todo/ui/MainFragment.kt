package com.info.todo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.info.todo.MainViewModel
import com.info.todo.R
import com.info.todo.TodoAdapter
import com.info.todo.databinding.FragmentMainBinding
import com.info.todo.local.TodoList
//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        viewModel = ViewModelProvider.NewInstanceFactory().create(MainViewModel::class.java)
        binding = FragmentMainBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        val todoAdapter = TodoAdapter(viewModel.allTodoList())
        val recyclerView: RecyclerView = binding.rvList

        recyclerView.adapter = todoAdapter
        binding.fabAdd.setOnClickListener {
            findNavController().navigate( R.id.action_mainFragment_to_addFragment)
        }
    }


}