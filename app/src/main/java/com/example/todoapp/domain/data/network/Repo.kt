package com.example.todoapp.domain.data.network

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.todoapp.model.TodoModel
import com.google.firebase.firestore.FirebaseFirestore

class Repo {
    private val db = FirebaseFirestore.getInstance()

    fun getTodoData():LiveData<MutableList<TodoModel>>{
        val mutableData = MutableLiveData<MutableList<TodoModel>>()
        db.collection("Todos").get().addOnSuccessListener {
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

    fun addTodoData(title:String, description:String){
        val todo = hashMapOf(
            "title" to title,
            "description" to description
        )
        db.collection("Todos").add(todo).addOnSuccessListener{
            Log.d("SuccessfulTag", "Datos agregados" )
        }.addOnFailureListener{
            Log.d("ErrorTag", "Datos NO agregados" )
        }
    }

    fun deleteTodoData(title:String){
       db.collection("Todos").whereEqualTo("title", title).get().addOnSuccessListener {
           for(document in it){
               document.reference.delete().addOnSuccessListener {
                   Log.d("SuccessfulTag", "Datos eliminados" )
               }.addOnFailureListener{
                   Log.d("ErrorTag", "Datos NO eliminados" )
               }
           }
       }.addOnFailureListener{
           Log.d("ErrorTag", "Datos NO encontrados" )
       }
    }

    fun updateTodoData(title:String, newData:Map<String, Any>){
        db.collection("Todos").whereEqualTo("title", title).get().addOnSuccessListener {
           for(document in it){
               document.reference.update(newData).addOnFailureListener{
                   Log.d("SuccessfulTag", "Datos actualizados" )
               }.addOnFailureListener{
                   Log.d("ErrorTag", "Datos NO actualizados" )
               }
           }
        }.addOnFailureListener{
            Log.d("ErrorTag", "Datos NO encontrados" )
        }
    }
}