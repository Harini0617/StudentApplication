package com.example.studentapplication

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.studentapplication.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTodoBinding
    private val todos = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, todos)
        binding.lvTodos.adapter = adapter

        binding.btnAddTodo.setOnClickListener {
            val newTodo = binding.etTodo.text.toString()
            if (newTodo.isNotEmpty()) {
                todos.add(newTodo)
                adapter.notifyDataSetChanged()
                binding.etTodo.text.clear()
            }
        }
    }
}