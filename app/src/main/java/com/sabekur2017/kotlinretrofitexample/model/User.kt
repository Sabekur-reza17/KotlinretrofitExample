package com.sabekur2017.kotlinretrofitexample.model

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("id")
    val id : Int,
    @SerializedName("name")
    val name : String,
    @SerializedName("avatar")
    val avatar : String,
    @SerializedName("email")
    val email : String
)