package com.example.book.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R
import com.example.book.model.Book
import java.security.AccessControlContext

class DashboardRecyclerAdapter(val context: Context, private val itemList: ArrayList<Book>): RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {

    class DashboardViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtBookName: TextView = view.findViewById(R.id.txtBookName)
        val txtBookAuthor: TextView = view.findViewById(R.id.txtAuthorName)
        val txtBookPrice: TextView = view.findViewById(R.id.txtPrice)
        val txtBookRating: TextView = view.findViewById(R.id.txtRating)
        val imgBookImage: ImageView = view.findViewById(R.id.imgBookImage)
        val content11: LinearLayout = view.findViewById(R.id.content11)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashboardViewHolder(view)
    }

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
      val book = itemList[position]
      holder.txtBookName.text = book.bookName
      holder.txtBookAuthor.text = book.bookAuthor
      holder.txtBookPrice.text = book.bookCost
      holder.txtBookRating.text = book.bookRating
      holder.imgBookImage.setImageResource(book.bookImage)

        holder.content11.setOnClickListener {
            Toast.makeText(context, "Clicked on ${holder.txtBookName.text}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
}