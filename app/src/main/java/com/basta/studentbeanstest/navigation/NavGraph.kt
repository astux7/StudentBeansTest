package com.basta.studentbeanstest.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.basta.studentbeanstest.presentation.image_list.ImageListScreen
import com.basta.studentbeanstest.presentation.sign_in.LoginScreen

fun NavGraphBuilder.buildTheGraph(navController: NavController) {
    composable(Directions.image_list.name) {
        ImageListScreen(navController)
    }

    composable(Directions.sign_in.name) {
        LoginScreen(navController)
    }
}