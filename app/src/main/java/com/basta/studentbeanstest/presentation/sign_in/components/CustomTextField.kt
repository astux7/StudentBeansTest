package com.basta.studentbeanstest.presentation.sign_in.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.basta.studentbeanstest.R
import com.basta.studentbeanstest.presentation.sign_in.FieldType

@Composable
fun CustomTextField(
    modifier: Modifier,
    type: FieldType,
    text: String,
    error: String? = null,
    onValueChange: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = { onValueChange(it) },
        isError = false,
        modifier = modifier.fillMaxWidth(),
        placeholder = {
            Text(
                text = stringResource(
                    if (type == FieldType.EMAIL) R.string.email_label else R.string.password_label
                )
            )
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = if (type == FieldType.EMAIL) KeyboardType.Email else KeyboardType.Password
        ),
        visualTransformation = if (type == FieldType.EMAIL) VisualTransformation.None else PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = if (error?.isNotBlank() == true) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors.onPrimary
            },
            unfocusedIndicatorColor = if (error?.isNotBlank() == true) {
                MaterialTheme.colors.error
            } else {
                MaterialTheme.colors.onPrimary
            },
            errorIndicatorColor = Color.Red
        )
    )

}