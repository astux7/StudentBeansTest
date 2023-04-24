package com.basta.studentbeanstest.presentation.image_list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.basta.studentbeanstest.presentation.components.NavBar
import org.koin.androidx.compose.getViewModel
import com.basta.studentbeanstest.R
import com.basta.studentbeanstest.common.Resource
import com.basta.studentbeanstest.navigation.Directions
import com.basta.studentbeanstest.presentation.components.NavTitle
import com.basta.studentbeanstest.presentation.image_list.components.PhotoListItem
import androidx.compose.foundation.lazy.items

@Composable
fun ImageListScreen(
    navController: NavController
) {
    val viewModel: ImageListViewModel = getViewModel()

    val state = viewModel.state.value

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

        when (state) {
            is Resource.Success -> {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.data.orEmpty()) { photo ->
                        PhotoListItem(photo = photo)
                    }
                }
            }

            is Resource.Error -> {
                AnimatedVisibility(visible = !state.message.isNullOrBlank()) {

                    Text(
                        text = state.message.orEmpty(),
                        color = MaterialTheme.colors.error,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    )
                }
            }

            is Resource.Loading -> {
                CircularProgressIndicator(modifier = Modifier)
            }
        }

    }
}
