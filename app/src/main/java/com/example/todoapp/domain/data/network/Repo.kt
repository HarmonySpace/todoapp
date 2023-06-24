package com.example.todoapp.domain.data.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.model.TodoModel
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Repo {
    fun getTodoData():LiveData<MutableList<TodoModel>>{
        val mutableData = MutableLiveData<MutableList<TodoModel>>()
        FirebaseFirestore.getInstance().collection("Todos").get().addOnSuccessListener {
            val listData = mutableListOf<TodoModel>()
            for(document in it){
                val title = document.getString("title")
                val description = document.getString("description")
                val todo = TodoModel(title!!, description!!)
                listData.add(todo)
            }
            mutableData.value = listData
        }
        return mutableData
    }
}