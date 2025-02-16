package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {

    // Vérification de l'état d'authentification de l'utilisateur
    val authViewModel = AuthViewModel()
    val authState = authViewModel.authState.observeAsState()


    if (authState.value == AuthViewModel.AuthState.UnAuthenticated) {
        // Redirection vers la page de connexion si l'utilisateur n'est pas authentifié
        navController.navigate(Routes.Login)
        return
    }

    else if (authState.value == AuthViewModel.AuthState.Authenticated) {
        // Affichage de la page d'accueil de l'application



        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.DarkGray)
                .padding(30.dp)
        )
        {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {

                Text("Bienvenue sur l'application", fontSize = 32.sp, color = Color.White)

                Spacer(modifier = Modifier.height(height = 40.dp))
                TextButton(onClick = {
                    authViewModel.logout()
                },
                    modifier = Modifier.size(width = 200.dp, height = 50.dp)
                ) { Text("Se déconnecter") }
            }
        }


    }


}