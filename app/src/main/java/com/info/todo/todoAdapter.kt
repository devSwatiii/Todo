package com.info.todo

import android.view.LayoutInflater
import android.view.ViewGroup

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.info.todo.databinding.ListViewBinding
import com.info.todo.local.TodoList

//import com.info.todo.local.TodoList




class TodoAdapter(val deleteItem: (TodoList)->Unit) :ListAdapter<TodoList, TodoAdapter.TodoViewHolder>(DIFF_CALLBACK) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = TodoViewHolder(
        ListViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )
    override fun onBindViewHolder(holder:TodoViewHolder , position: Int) {
        holder.bindLast(getItem(position),deleteItem)

    }
    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TodoList>() {
            override fun areItemsTheSame(
                oldItem: TodoList,
                newItem: TodoList,
            ): Boolean = oldItem.id == newItem.id
            override fun areContentsTheSame(
                oldItem: TodoList,
                newItem: TodoList,
            ): Boolean = oldItem == newItem
        }
    }
    inner class TodoViewHolder(private val binding: ListViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindLast(item: TodoList, deleteItem: (TodoList) -> Unit) {
            binding.apply {
                tvDesc.text = item.description
                tvTitle.text = item.title
                tvPri.text = item.priority.toString()
                delete.setOnClickListener {
                    deleteItem(item)
                }

            }
        }
    }
}
