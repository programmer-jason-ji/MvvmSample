package com.example.mvvmkotlindemo.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmkotlindemo.R
import com.example.mvvmkotlindemo.model.Book

/**
 * created by Jason Ji
 * on 2020-04-12
 */
class BookAdapter: RecyclerView.Adapter<BookAdapter.MyViewHolder>() {

    private var list:List<Book> = ArrayList()

    fun setData(list:List<Book>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(
                R.layout.listview_book,
                parent,
                false
            ))
    }

    override fun getItemCount(): Int {
       return  list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            var model = list[position]
            holder.name.setText(model.name)
            holder.year.setText(""+model.year)
      }

    inner class MyViewHolder(convertView: View): RecyclerView.ViewHolder(convertView){

          var name:TextView
          var year:TextView

        init{
            name = convertView.findViewById(R.id.name) as TextView
            year = convertView.findViewById(R.id.year) as TextView
        }

    }

}