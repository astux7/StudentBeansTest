package com.basta.studentbeanstest.presentation.image_list

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.getViewModel

@Composable
fun ImageListScreen(
    navController: NavController,
    viewModel: ImageListViewModel = getViewModel()
) {
    Text(text = "Images")
}