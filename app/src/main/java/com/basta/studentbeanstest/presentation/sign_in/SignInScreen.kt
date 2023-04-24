package com.basta.studentbeanstest.presentation.sign_in

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.basta.studentbeanstest.R
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel: SignInViewModel = getViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            text = stringResource(R.string.welcome_label),
            style = TextStyle(
                fontWeight = FontWeight(900),
                fontSize = 24.sp
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Start),
            text = stringResource(R.string.sign_in_body_label)
        )

        Spacer(modifier = Modifier.height(35.dp))

        TextField(
            value = "",
            onValueChange = {

            },
            isError = false,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(R.string.email_label))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        TextField(
            value = "",
            onValueChange = {

            },
            isError = false,
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text(text = stringResource(R.string.password_label))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onPrimary),
        ) {
            Text(text = stringResource(R.string.sign_in_label), color = MaterialTheme.colors.background)
        }
    }
}