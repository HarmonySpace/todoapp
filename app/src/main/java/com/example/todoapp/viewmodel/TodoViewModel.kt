package com.example.todoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.TasksProvider
import com.example.todoapp.model.TodoModel
import com.example.todoapp.domain.data.network.Repo
import com.google.firebase.firestore.FirebaseFirestore

class TodoViewModel : ViewModel() {
    private val repo = Repo()

    fun fetchTodoData():LiveData<MutableList<TodoModel>>{
        val mutableData = MutableLiveData<MutableList<TodoModel>>()
        repo.getTodoData().observeForever(){
            mutableData.value = it
        }
        return mutableData
    }

    fun addTodo(title:String, description:String){
       repo.addTodoData(title, description)
    }

    fun deleteTodo(title:String){
       repo.deleteTodoData(title)
    }

    fun updateTodo(title:String, newData: Map<String, Any>){
        repo.updateTodoData(title, newData)
    }

}