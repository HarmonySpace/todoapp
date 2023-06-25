package com.example.todoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.todoapp.R
import com.example.todoapp.viewmodel.TodoViewModel

class UpdateActivity : AppCompatActivity() {
    private lateinit var btCancel: Button
    private lateinit var btAdd:Button
    private lateinit var etTitle: EditText
    private lateinit var etDescription:EditText
    private val viewModel by lazy { ViewModelProvider(this)[TodoViewModel::class.java] }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)
        btCancel = findViewById(R.id.btCancel)
        btAdd = findViewById(R.id.btAdd)
        etTitle = findViewById(R.id.etTitle)
        etDescription = findViewById(R.id.etDescription)
        btCancel.setOnClickListener(){
            changeMainActivity("Cancel")
        }
        btAdd.setOnClickListener(){
            addOneTodo("Add item")
        }
    }

    private fun changeMainActivity (message:String) {
       toastMessage(message)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun addOneTodo(message: String) {
        val title:String = etTitle.text.toString()
        val description:String = etDescription.text.toString()
        viewModel.addTodo(title, description)
        changeMainActivity(message)
    }

    private fun toastMessage (message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}