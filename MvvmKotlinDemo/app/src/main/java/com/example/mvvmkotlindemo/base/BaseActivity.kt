package com.example.mvvmkotlindemo.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mvvmkotlindemo.viewmodel.BookViewModel

/**
 * created by Jason Ji
 * on 2020-04-11
 */
abstract class BaseActivity<T:BaseViewModel> : AppCompatActivity() {

   abstract var mViewModel: BookViewModel

   abstract fun initViewModel()

   abstract fun setLayout()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setLayout()
        initViewModel()
    }


}