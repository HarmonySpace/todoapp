package com.example.todoapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.model.TasksProvider
import com.example.todoapp.model.TodoModel

class TodoViewModel : ViewModel() {
    fun fetchTodoData():LiveData<MutableList<TodoModel>>{
       val mutableData = MutableLiveData<MutableList<TodoModel>>()
    }

    //val todoModels = MutableLiveData<List<TodoModel>>()
    //val todoModel= MutableLiveData<TodoModel>()

    //fun getTask(){
    //    val aTodo = TasksProvider.getTaskP(0)
    //    todoModel.postValue(aTodo)
    //}

    //fun getAllTasks(){
    //    val allTodos = TasksProvider.getTasksP()
    //    todoModels.postValue(allTodos)
    //}
}