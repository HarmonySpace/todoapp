package com.example.todoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
//import com.example.todoapp.model.TodoModel
import com.example.todoapp.viewmodel.TodoViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var btAddActivity:Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter:MainAdapter
    //private val viewModel by lazy { ViewModelProvider(this).get(TodoViewModel::class.java) }
    private val viewModel by lazy { ViewModelProvider(this)[TodoViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        observeData()
        adapter = MainAdapter(this)
        recyclerView = findViewById(R.id.rvTodos)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        //buttons
        btAddActivity = findViewById(R.id.btAddActivity)
        btAddActivity.setOnClickListener{
            changeActivity("Add")
        }
    }

    private fun changeActivity (message:String = "nothing") {
        toastMessage(message)
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
        finish()
    }

    private fun toastMessage (message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun observeData(){
        viewModel.fetchTodoData().observe(this, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

}