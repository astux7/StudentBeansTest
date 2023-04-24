package com.basta.studentbeanstest.presentation.image_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.basta.studentbeanstest.presentation.components.NavBar
import org.koin.androidx.compose.getViewModel
import com.basta.studentbeanstest.R
import com.basta.studentbeanstest.navigation.Directions
import com.basta.studentbeanstest.presentation.components.NavTitle

@Composable
fun ImageListScreen(
    navController: NavController,
    viewModel: ImageListViewModel = getViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top,
    ) {
        NavBar(
            {
                NavTitle(text = stringResource(id = R.string.image_list_title))
            },
            leftIcon = R.drawable.ic_back,
            rightIcon = null,
            onLeftIconClick = {
                navController.navigate(Directions.sign_in.name)
            },
            onRightIconClick = { },
        )


    }
}
