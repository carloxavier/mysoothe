package com.example.androiddevchallenge.welcome

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomePage(navController: NavHostController? = null) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(stringResource(R.string.welcome_title))
            Spacer(modifier = Modifier.height(32.dp))
            SignupButton(navController)
            Spacer(modifier = Modifier.height(8.dp))
            LoginButton(navController)
        }
    }
}

@Composable
fun SignupButton(navController: NavHostController? = null) {
    Button(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth(),
        onClick = { navController?.navigate("signup") },
    ) {
        Text(stringResource(R.string.signup_button))
    }
}

@Composable
fun LoginButton(navController: NavHostController? = null) {
    Button(
        modifier = Modifier
            .height(72.dp)
            .fillMaxWidth(),
        onClick = { navController?.navigate("login") },
    ) {
        Text(stringResource(R.string.login_button))
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    Scaffold {
        MyTheme {
            WelcomePage()
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    Scaffold {
        MyTheme(darkTheme = true) {
            WelcomePage()
        }
    }
}