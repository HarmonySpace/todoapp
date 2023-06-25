package com.example.todoapp.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.model.TodoModel
import com.example.todoapp.viewmodel.TodoViewModel

class MainAdapter(private val context:Context): RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    private var dataList = mutableListOf<TodoModel>()
    private val viewModel by lazy { ViewModelProvider(context as ViewModelStoreOwner)[TodoViewModel::class.java] }

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
        holder.itemView.setOnLongClickListener(){
            val popup = PopupMenu(context, it)
            popup.inflate(R.menu.menu_item)
            popup.setOnMenuItemClickListener {
                when ( it.itemId){
                   R.id.option1 -> {
                       val intent = Intent(context, AddActivity::class.java)
                       intent.putExtra("title", user.title)
                       intent.putExtra("description", user.description)
                       context.startActivity(intent)
                       true
                   }
                   R.id.option2 -> {
                       val currentTodo = user.title
                       viewModel.deleteTodo(currentTodo)
                       dataList.removeAt(position)
                       notifyItemRemoved(position)
                       true
                   }
                    else -> false
                }
            }
            popup.show()
            true
        }
    }
    inner class MainViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bindView(todo:TodoModel) {
            //Glide.with(context).load(todo.title).into(tvTodoTitle)
            itemView.findViewById<TextView>(R.id.tvTodoTitle).text = todo.title
            itemView.findViewById<TextView>(R.id.tvTodoDescription).text = todo.description
        }
    }
}