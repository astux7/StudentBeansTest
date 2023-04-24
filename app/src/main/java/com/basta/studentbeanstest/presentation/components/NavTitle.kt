package com.basta.studentbeanstest.presentation.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun NavTitle(text: String) {
    Text(
        modifier = Modifier,
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        color = MaterialTheme.colors.primary
    )
}