package com.example.todoapp.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.model.TodoModel

class MainAdapter(private val context:Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<TodoModel>()

    fun setListData(data:MutableList<TodoModel>){
        dataList = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false)
        return MainViewHolder(view)
    }
    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return if (dataList.size > 0) {
            dataList.size
        } else {
            0
        }
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val user = dataList[position]
        holder.bindView(user)
    }
    inner class MainViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindView(todo:TodoModel) {
            //Glide.with(context).load(todo.title).into(tvTodoTitle)
            itemView.findViewById<TextView>(R.id.tvTodoTitle).text = todo.title
            itemView.findViewById<TextView>(R.id.tvTodoDescription).text = todo.description
        }
    }
}