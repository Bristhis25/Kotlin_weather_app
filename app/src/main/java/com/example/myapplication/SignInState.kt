package com.example.myapplication

data class SignInState(
    val isSignInSuccessful: Boolean = false,
    val signInError: String? = null
)