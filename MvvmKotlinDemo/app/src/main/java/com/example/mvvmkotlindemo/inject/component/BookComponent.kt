package com.example.mvvmkotlindemo.inject.component

import com.example.mvvmkotlindemo.inject.module.BookModule
import com.example.mvvmkotlindemo.viewmodel.BookViewModel
import dagger.Component

/**
 * created by Jason Ji
 * on 2020-04-11
 */
@Component(modules = [(BookModule::class)])
interface BookComponent {

    fun inject(bookViewModel: BookViewModel)

}