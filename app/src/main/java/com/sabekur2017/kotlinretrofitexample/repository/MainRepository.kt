package com.sabekur2017.kotlinretrofitexample.repository

import com.sabekur2017.kotlinretrofitexample.api.ApiHelper
import com.sabekur2017.kotlinretrofitexample.model.User
import io.reactivex.Single

class MainRepository(private val apiHelper: ApiHelper){
  fun getUsers():Single<List<User>>{
      return apiHelper.getUsers()

  }
}