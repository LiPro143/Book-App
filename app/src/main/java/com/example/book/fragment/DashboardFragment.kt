package com.example.book.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.book.R
import com.example.book.adapter.DashboardRecyclerAdapter
import com.example.book.model.Book

class DashboardFragment : Fragment() {

    lateinit var recyclerDashboard: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager

    val bookList = arrayListOf("P.S I Love You", "The Great Gatsby", "Anna Karenina", "Madame Bovary", "War and Peace",
    "Lolita", "Middlemarch", "The Adventure of Huckleberry Finn", "Moby-Dick", "The LOrd of the Rings")

    lateinit var recyclerAdepter: DashboardRecyclerAdapter

val bookInfoList = arrayListOf<Book>(
    Book("P.S I Love You", "Cecelia Ahern", "Rs.299", "4.5",R.drawable.image1),
Book("The Great Gatsby", "Leo Tolstoy", "Rs. 249", "4.8", R.drawable.image2),
Book("Anna Karenina", "Vladimir Nabokov", "Rs. 349", "4.8", R.drawable.image3),
Book("Madame Bovary", "George Elliot", "Rs. 359", "4.5", R.drawable.image4),
Book("War and Peace", "George Elliot", "Rs. 359", "4.5", R.drawable.image5),
Book("Lolita", "George Elliot", "Rs. 359", "4.5", R.drawable.image6),
Book("Middlemarch", "George Elliot", "Rs. 359", "4.5", R.drawable.image7),
Book("The Adventure of Huckleberry Finn", "George Elliot", "Rs. 359", "4.5", R.drawable.image8),
Book("Moby-Dick", "George Elliot", "Rs. 359", "4.5", R.drawable.image9),
Book("The LOrd of the Rings", "George Elliot", "Rs. 359", "4.5", R.drawable.image10)
)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        recyclerDashboard = view.findViewById(R.id.recyclerDashboard)
        layoutManager = LinearLayoutManager(activity)
        recyclerAdepter= DashboardRecyclerAdapter(activity as Context, bookInfoList)

        recyclerDashboard.adapter = recyclerAdepter
        recyclerDashboard.layoutManager = layoutManager

        return view
    }

}