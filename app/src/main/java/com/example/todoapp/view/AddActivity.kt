package com.example.todoapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import com.example.todoapp.R

class AddActivity : AppCompatActivity() {
    private lateinit var btCancel:Button
    private lateinit var btAdd:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        btCancel = findViewById(R.id.btCancel)
        btAdd = findViewById(R.id.btAdd)
        btCancel.setOnClickListener(){
            changeMainActivity("Cancel")
        }
        btAdd.setOnClickListener(){
            toastMessage("Add item")
        }
    }

    private fun changeMainActivity (message:String) {
       toastMessage(message)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun toastMessage (message:String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}