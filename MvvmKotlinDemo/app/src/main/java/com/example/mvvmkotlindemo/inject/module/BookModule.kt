package com.example.mvvmkotlindemo.inject.module

import com.example.mvvmkotlindemo.repository.BookRepository
import dagger.Module
import dagger.Provides

/**
 * created by Jason Ji
 * on 2020-04-11
 */
@Module
class BookModule {

    @Provides
    fun provideBook():BookRepository{
        return BookRepository()
    }

}