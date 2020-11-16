package com.sabekur2017.kotlinretrofitexample.ui.base

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sabekur2017.kotlinretrofitexample.api.ApiHelper
import com.sabekur2017.kotlinretrofitexample.repository.MainRepository
import com.sabekur2017.kotlinretrofitexample.ui.main.viewmodel.MainViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory(private val apiHelper: ApiHelper):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MainViewModel::class.java)){
            return MainViewModel(MainRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}