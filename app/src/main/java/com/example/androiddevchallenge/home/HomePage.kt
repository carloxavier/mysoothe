package com.example.androiddevchallenge.home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun HomePage(navController: NavHostController) {
    Scaffold {
        Text(text = "home")
    }
}