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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    Scaffold { innerPadding ->
        LoginPage(Modifier.padding(innerPadding))
    }
}

@Composable
fun LoginPage(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("LOG IN")
        Spacer(Modifier.height(32.dp))
        LoginTextField()
        Spacer(Modifier.height(8.dp))
        PasswordTextField()
        Spacer(Modifier.height(8.dp))
        LoginButton()
        Spacer(Modifier.height(16.dp))
        SignupLink()
    }
}

@Composable
fun LoginTextField(modifier: Modifier = Modifier) {
    val textState = remember { mutableStateOf(TextFieldValue()) }

    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textState.value,
        onValueChange = { textState.value = it },
        label = { Text("Email address") },
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
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
    )
}

@Composable
fun LoginButton(modifier: Modifier = Modifier) {
    Button(
        modifier = modifier
            .height(72.dp)
            .fillMaxWidth(),
        onClick = { /*TODO*/ },
    ) {
        Text("LOG IN")
    }
}

@Composable
fun SignupLink(modifier: Modifier = Modifier) {
    Text(
        buildAnnotatedString {
            append("Don't have an account?")
            append("  ")
            withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                append("Sign up")
            }
        },
        modifier = modifier,
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
