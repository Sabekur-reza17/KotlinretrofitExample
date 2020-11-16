package com.sabekur2017.kotlinretrofitexample.api

import com.sabekur2017.kotlinretrofitexample.model.User
import io.reactivex.Single

interface ApiService {
   /* @GET("users")
    suspend fun getUsers():List<User>*/

    fun getUsers(): Single<List<User>>
}