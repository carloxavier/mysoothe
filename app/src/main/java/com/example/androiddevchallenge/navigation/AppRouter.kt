/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.home.HomePage
import com.example.androiddevchallenge.login.LoginPage
import com.example.androiddevchallenge.signup.SignupPage
import com.example.androiddevchallenge.welcome.WelcomePage

@Composable
fun AppRouter() {
    rememberNavController().let { navController ->
        NavHost(navController, startDestination = Route.Welcome.path) {
            composable(Route.Welcome.path) {
                WelcomePage(navController)
            }
            composable(Route.Signup.path) {
                SignupPage(navController)
            }
            composable(Route.Login.path) {
                LoginPage(navController)
            }
            composable(Route.Home.path) {
                HomePage(navController)
            }
        }
    }
}

sealed class Route(val path: String) {
    object Welcome : Route("welcome")
    object Signup : Route("signup")
    object Login : Route("login")
    object Home : Route("home")
}
