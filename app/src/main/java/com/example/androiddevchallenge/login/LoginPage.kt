package com.example.androiddevchallenge.login

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.MyTheme


@Composable
fun LoginPage(navHostController: NavHostController? = null) {
    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(stringResource(R.string.login_title))
            Spacer(Modifier.height(32.dp))
            LoginTextField()
            Spacer(Modifier.height(8.dp))
            PasswordTextField()
            Spacer(Modifier.height(8.dp))
            LoginButton(navHostController = navHostController)
            Spacer(Modifier.height(16.dp))
            SignupLink()
        }
    }
}

@Composable
fun LoginTextField(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(stringResource(R.string.email)) },
        singleLine = true,
    )
}

@Composable
fun PasswordTextField(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text(stringResource(R.string.password)) },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
    )
}

@Composable
fun LoginButton(modifier: Modifier = Modifier, navHostController: NavHostController? = null) {
    Button(
        modifier = modifier
            .height(72.dp)
            .fillMaxWidth(),
        onClick = { navHostController?.navigate("home") },
    ) {
        Text(stringResource(R.string.login_button))
    }
}

@Composable
fun SignupLink(modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            append("Don't have an account?")
            append("  ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append(stringResource(R.string.signup_button))
            }
        },
        modifier = modifier,
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    Scaffold {
        MyTheme {
            LoginPage()
        }
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    Scaffold {
        MyTheme(darkTheme = true) {
            LoginPage()
        }
    }
}
