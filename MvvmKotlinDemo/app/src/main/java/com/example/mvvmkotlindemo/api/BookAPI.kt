package com.example.mvvmkotlindemo.api

import com.example.mvvmkotlindemo.model.Book
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * created by Jason Ji
 * on 2020-04-11
 */
interface BookAPI {

    @GET("api/book/getBooks")
    fun getBooks(@Header("Cookie") cookie:String, @Query("shelfId") shelfId:String)
            :Flowable<List<Book>>

}