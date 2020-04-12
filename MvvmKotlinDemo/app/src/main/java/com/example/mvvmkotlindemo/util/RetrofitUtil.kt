package com.example.mvvmkotlindemo.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * created by Jason Ji
 * on 2020-04-12
 */
class RetrofitUtil {

    companion object{

        private val BASE_URL:String = "https://google.com"

        private val httpClient:OkHttpClient.Builder = OkHttpClient.Builder()

        private val builder: Retrofit.Builder = Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        private var retrofit:Retrofit = builder.client((httpClient.build())).build()

        fun <T>createService(serviceClass:Class<T>):T {
            return retrofit.create(serviceClass)
        }

    }

}