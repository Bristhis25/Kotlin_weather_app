package com.example.myapplication

data class SignInResult(
    val data: com.example.myapplication.UserData?,
    val errorMessage: String?
)

data class UserData(
    val userId: String,
    val username: String?,
    val profilePictureUrl: String?
)
