package com.basta.studentbeanstest.presentation.sign_in

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.basta.studentbeanstest.R
import com.basta.studentbeanstest.presentation.sign_in.components.CustomTextField
import org.koin.androidx.compose.getViewModel

@Composable
fun LoginScreen(
    navController: NavController
) {
    val viewModel: SignInViewModel = getViewModel()
    val state = viewModel.state

    var email by remember { mutableStateOf(state.email) }
    var password by remember { mutableStateOf(state.password) }

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

        CustomTextField(Modifier, FieldType.EMAIL, email, state.emailError) {
            email = it
        }

        state.emailError?.let {
            Text(
                text = it,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        CustomTextField(Modifier, FieldType.PASSWORD, password, state.passwordError) {
            password = it
        }

        state.passwordError?.let {
            Text(
                text = it,
                color = MaterialTheme.colors.error,
                modifier = Modifier.align(Alignment.End)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                viewModel.submit(email, password) { direction ->
                    navController.navigate(direction)
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.End),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.onPrimary),
        ) {
            Text(
                text = stringResource(R.string.sign_in_label),
                color = MaterialTheme.colors.background
            )
        }
    }
}