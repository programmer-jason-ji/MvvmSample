package com.example.mvvmkotlindemo.ui.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmkotlindemo.R
import com.example.mvvmkotlindemo.base.BaseActivity
import com.example.mvvmkotlindemo.inject.component.DaggerBookComponent
import com.example.mvvmkotlindemo.model.Book
import com.example.mvvmkotlindemo.ui.adapter.BookAdapter
import com.example.mvvmkotlindemo.viewmodel.BookViewModel
import kotlinx.android.synthetic.main.activity_main.*

class BookActivity : BaseActivity<BookViewModel>() {

    override lateinit var mViewModel:BookViewModel

    override fun initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(BookViewModel::class.java)
    }

    override fun setLayout() {
         setContentView(R.layout.activity_main)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inject the repository into viewModel
        DaggerBookComponent.builder().build().inject(mViewModel)

        var bookAdapter: BookAdapter = BookAdapter()
        book_list.layoutManager =  LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL, false)
        book_list.adapter = bookAdapter

        // fetch and observe the data from the server
        mViewModel.getBooks("cookie","123456").observe(this,
            object:Observer<List<Book>> {
                override fun onChanged(data: List<Book>?) {
                    if(data != null)
                    bookAdapter.setData(data)
                }
            })


    }

}
