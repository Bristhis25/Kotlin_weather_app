package com.example.myapplication

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(
    navController: NavController,
    state: SignInState,
    onSignInClick: () -> Unit
){

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    val authViewModel = AuthViewModel()
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    LaunchedEffect(authState.value){
        when(authState.value){
            is AuthViewModel.AuthState.Authenticated ->
                navController.navigate(Routes.Home)
            is AuthViewModel.AuthState.Error -> Toast.makeText(context,
                (authState.value as AuthViewModel.AuthState.Error).message, Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }



    Box(
        modifier = Modifier.background(color = Color.DarkGray)) {

        Text("< Retour", style = TextStyle(color = Color.White, fontSize = 15.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(top = 40.dp, start = 10.dp)
                .clickable {  }
        )
        Spacer(modifier = Modifier.height(height = 40.dp))

        Column(

            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){


            Text("Connexion", color = Color.White, fontSize = 25.sp, fontWeight = FontWeight.SemiBold)
            Spacer(modifier = Modifier.height(height = 20.dp))
            Image(painter = painterResource(R.drawable.boy), contentDescription = "profile",
                modifier = Modifier.size(size = 100.dp))
            Spacer(modifier = Modifier.height(height = 25.dp))

            //Les textes box
            OutlinedTextField(
                value = email, onValueChange = {
                email = it
            }, modifier = Modifier.width(width = 230.dp) ,
                label = { Text("Email", style = TextStyle(color = Color.White)) },
                        textStyle = TextStyle(color = Color.White),

            )
            Spacer(modifier = Modifier.height(height = 16.dp))

            OutlinedTextField(value = password, onValueChange = {
                password = it
            }, modifier = Modifier.width(width = 230.dp) ,
                label = {
                    Text("Mot de Passe", style = TextStyle(color = Color.White))
                }, visualTransformation = PasswordVisualTransformation(),
                        textStyle = TextStyle(color = Color.White)
                )

            Spacer(modifier = Modifier.height(height = 17.dp))
            // Button Connecté
            Button(
                colors = ButtonColors(containerColor = Color.Gray, contentColor = Color.White, disabledContentColor = Color.Gray, disabledContainerColor = Color.Gray),
                onClick = {
                    //Action pour la connexion avec mot de passe et email
                    authViewModel.login(email, password)

                },
                        enabled = authState.value != AuthViewModel.AuthState.Loading
            )
            {
                Text("Se Connecter")
            }

            Spacer(modifier = Modifier.height(height = 35.dp))

            Text("Mot de Passe oublié ?", modifier = Modifier.clickable { navController.navigate(Routes.ForgottenPassword) },style = TextStyle(textDecoration = TextDecoration.Underline, fontWeight = FontWeight.Bold, color = Color.White))

            Spacer(modifier = Modifier.height(height = 15.dp))

            Divider(modifier = Modifier.width(width = 240.dp), color = Color.White)

            Spacer(modifier = Modifier.height(height = 15.dp))

            Row {
                Image(painter = painterResource(R.drawable.search), contentDescription = "connexion via google", Modifier.size(size = 17.dp))
                Spacer(modifier= Modifier.width(width = 7.dp))
                Text("S’authentifier avec Google", style = TextStyle(color = Color.White), modifier = Modifier.clickable
                {
                //Action pour la connexion via google
                onSignInClick()


                })

            }
            Spacer(modifier = Modifier.height(height = 15.dp))

            Row {
                Text("Ou", color = Color.White)
                Spacer(modifier = Modifier.width(width = 7.dp))
                Text("S'inscrire", style = TextStyle(textDecoration = TextDecoration.Underline), color = Color.White, modifier = Modifier.clickable { navController.navigate(Routes.Register) })
            }

        }

    }}