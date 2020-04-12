package com.example.mvvmkotlindemo.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.mvvmkotlindemo.base.BaseViewModel
import com.example.mvvmkotlindemo.model.Book
import com.example.mvvmkotlindemo.repository.BookRepository
import javax.inject.Inject

/**
 * created by Jason Ji
 * on 2020-04-11
 */
class BookViewModel:BaseViewModel() {

    @Inject
    lateinit var bookRepository: BookRepository

    fun getBooks(cookie:String,shelfId:String): MutableLiveData<List<Book>> {
                bookRepository.getBooks(cookie,shelfId)
         return bookRepository.getBooks(cookie,shelfId)
    }


}