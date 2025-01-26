package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun MyAppNavigation(){
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Login, builder = {
        composable(
            Routes.Login){
            LoginScreen(navController)
        }

        composable(
            Routes.Register){
            Register(navController)
        }
        composable(
            Routes.ForgottenPassword
        ) {
            ForgottenPassword(navController)
        }
    })

}