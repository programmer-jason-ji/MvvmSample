package com.example.mvvmkotlindemo.repository

import androidx.lifecycle.MutableLiveData
import com.example.mvvmkotlindemo.api.BookAPI
import com.example.mvvmkotlindemo.model.Book
import com.example.mvvmkotlindemo.util.RetrofitUtil
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * created by Jason Ji
 * on 2020-04-11
 */
class BookRepository {

    private var booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks(cookie:String,shelfId:String):MutableLiveData<List<Book>>{

        // mock data
        var book1 =  Book("book1",2009)
        var book2 =  Book("book2",2012)
        var list:MutableList<Book> = ArrayList()
        list.add(book1)
        list.add(book2)

        var bookService: BookAPI = RetrofitUtil.createService(BookAPI::class.java)

        // get the data from service by retrofit
        bookService.getBooks(cookie,shelfId).toObservable()
            .subscribeOn(Schedulers.io())
            .subscribe(object:Observer<List<Book>>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: List<Book>) {
                    booksLiveData.postValue(t)
                }

                override fun onError(e: Throwable) {
                    // for testing mock data
                    booksLiveData.postValue(list)
                }
            })
        return booksLiveData;
    }

}