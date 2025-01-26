package com.example.myapplication

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Register(navController: NavController){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    var passwordconfirmed by remember {
        mutableStateOf("")
    }
    Box(
        modifier = Modifier.background(color = Color.DarkGray)
    ){
        Text("< Retour", style = TextStyle(color = Color.White, fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(top = 40.dp, start = 10.dp)
                .clickable { navController.navigate(Routes.Login) }
        )
        Spacer(modifier = Modifier.height(height = 40.dp))
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){

            Text("Inscription", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(height = 50.dp))
            OutlinedTextField(value = email, onValueChange = {
                email = it
            }, modifier = Modifier.width(width = 230.dp) ,
                label = {
                    Text("Email", style = TextStyle(color = Color.White))
                })
            Spacer(modifier = Modifier.height(height = 16.dp))

            OutlinedTextField(value = password, onValueChange = {
                password = it
            }, modifier = Modifier.width(width = 230.dp) ,
                label = {
                    Text("Mot de Passe", style = TextStyle(color = Color.White))
                }, visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(height = 16.dp))

            OutlinedTextField(value = passwordconfirmed, onValueChange = {
                passwordconfirmed = it
            }, modifier = Modifier.width(width = 230.dp) ,
                label = {
                    Text("Confirmez mot de passe", style = TextStyle(color = Color.White))
                }, visualTransformation = PasswordVisualTransformation() )

            Spacer(modifier = Modifier.height(height = 20.dp))

            Button(
                colors = ButtonColors(containerColor = Color.Gray, contentColor = Color.White, disabledContentColor = Color.Gray, disabledContainerColor = Color.Gray),
                onClick = {}) {
                Text("S'inscrire")
            }

            Spacer(modifier = Modifier.height(height = 15.dp))

            Divider(modifier = Modifier.width(width = 240.dp), color = Color.White)

            Spacer(modifier = Modifier.height(height = 15.dp))

            Row {
                Modifier.fillMaxWidth()
                Text("Vous avez déjà un compte ?", color = Color.White)
                Spacer(modifier = Modifier.width(width = 7.dp))
                Text("Se Connecter", color = Color.White, modifier = Modifier.clickable { navController.navigate(Routes.Login) }, textDecoration = TextDecoration.Underline)
            }
        }

    }
}