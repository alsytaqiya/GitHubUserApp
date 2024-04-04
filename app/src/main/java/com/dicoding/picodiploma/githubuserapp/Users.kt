package com.dicoding.picodiploma.githubuserapp

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    var fullname: String,
    var username: String,
    var avatar: Int,
    var location: String,
    var repository: String,
    var company: String,
    var followers: String,
    var following: String,

) : Parcelable
