package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment


@Composable
fun ForgottenPassword(navController: NavController){

    var email by remember {
        mutableStateOf("")
    }

    Box(
        modifier = Modifier.background(color = Color.DarkGray)){
        Text("< Retour", modifier = Modifier
            .padding(top = 40.dp, start = 10.dp)
            .align(alignment = Alignment.TopStart)
            .clickable { navController.navigate(Routes.Login) },
            color = Color.White
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Mot de Passe Oublié ?", style = TextStyle(fontWeight = FontWeight.Bold, fontSize = 25.sp, color = Color.White))
            Spacer(modifier = Modifier.height(height = 40.dp))
            Text("Veuillez saisir votre email de connexion afin\n" +
                    "de recevoir le lien de réinitialisation de votre\n" +
                    "mot de passe.", color = Color.White)
            Spacer(modifier = Modifier.height(height = 20.dp))
            OutlinedTextField(value = email, onValueChange = {
                email = it
            }, modifier = Modifier.width(width = 240.dp) ,
                label = {
                    Text("Email", style = TextStyle(color = Color.White))
                })
            Spacer(modifier = Modifier.height(height = 15.dp))
            Button(
                colors = ButtonColors(containerColor = Color.Gray, contentColor = Color.White, disabledContentColor = Color.Gray, disabledContainerColor = Color.Gray),
                onClick = {}) {
                Text("Recevoir le lien", color = Color.White)
            }
        }

    }


}