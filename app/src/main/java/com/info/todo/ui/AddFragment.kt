package com.info.todo.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.info.todo.databinding.FragmentAddBinding
import com.info.todo.local.TodoList
import com.info.todo.utils.shortToast
import com.info.todo.viewmodels.MainViewModel


class AddFragment : Fragment() {
     private val viewModel: MainViewModel by activityViewModels()
    private lateinit var binding: FragmentAddBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddBinding.inflate(inflater, container, false)

        return binding.root
    }


    override fun onStart() {
        super.onStart()
        if(binding.etDes.text?.isNotEmpty() == true && binding.etDes.text?.isNotEmpty()!! && binding.etDes.text?.isNotEmpty() == true){
            binding.submitBtn?.setOnClickListener {

                viewModel.addTodoList(
                    TodoList(
                        description = binding.etDes.text.toString(),
                        title = binding.etTitle.text.toString(),
                        priority = binding.etPri.text.toString().toInt()
                    )
                )
                context?.shortToast("Your notes saved successfully")
                findNavController().navigateUp()
            }
        }else{
            context?.shortToast("enter some notes")

        }




    }
}