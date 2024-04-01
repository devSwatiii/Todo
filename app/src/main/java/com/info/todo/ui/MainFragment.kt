package com.info.todo.ui


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.info.todo.R
import com.info.todo.TodoAdapter
import com.info.todo.databinding.FragmentMainBinding
import com.info.todo.local.TodoList
import com.info.todo.utils.shortToast
import com.info.todo.viewmodels.MainViewModel

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val viewModel: MainViewModel by activityViewModels()
    val todoAdapter = TodoAdapter(::deleteNote)

    private fun deleteNote(todoList: TodoList) {
        viewModel.deleteTodoList(todoList)
       context?.shortToast("Deleted")


    }








    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()

        viewModel.allTodoList().observe(viewLifecycleOwner) {
            it?.let {
                todoAdapter.submitList(it)
                val recyclerView: RecyclerView = binding.rvList

                recyclerView.adapter = todoAdapter



            }
        }

        binding.fabAdd.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_addFragment)
        }


        binding.search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (s.toString().isNotEmpty()) {

                    val text = s.toString()
                    val query = "%$text%"
                    if (query.isNotEmpty()) {
                        viewModel.searchData(query).observe(viewLifecycleOwner) {
                            todoAdapter.submitList(it)
                        }
                    } else {
                        observerDataChanges()
                    }
                } else {
                    observerDataChanges()
                }
            }

            override fun afterTextChanged(s: Editable?) {
                if (s.toString().isEmpty()) {

                }
            }
        })

    }
    private fun observerDataChanges() {
        viewModel.allTodoList().observe(viewLifecycleOwner) { list ->

            todoAdapter.submitList(list)
        }
    }
}