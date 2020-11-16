package com.sabekur2017.kotlinretrofitexample.api

class ApiHelper(private val apiService: ApiService) {
    fun getUsers()=apiService.getUsers()
}