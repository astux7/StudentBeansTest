package com.basta.studentbeanstest.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.basta.studentbeanstest.R

@Composable
fun NavBar(
    centerContent: @Composable () -> Unit,
    @DrawableRes leftIcon: Int? = null,
    @DrawableRes rightIcon: Int? = null,
    onLeftIconClick: () -> Unit,
    onRightIconClick: () -> Unit
) {
    Surface(
        modifier = Modifier.background(color = MaterialTheme.colors.background)
    ) {
        Box(
            Modifier
                .background(color = MaterialTheme.colors.background)
                .fillMaxWidth()
                .height(56.dp)
                .padding(4.dp),
        ) {
            leftIcon?.let { leftIcon ->
                Box(Modifier.align(Alignment.CenterStart)) {

                    IconButton(
                        onClick = onLeftIconClick,
                        modifier = Modifier,
                    ) {
                        Icon(
                            painter = painterResource(leftIcon),
                            contentDescription = stringResource(R.string.navigation_icon_label),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }

            Box(Modifier.align(Alignment.Center)) {
                centerContent()
            }

            rightIcon?.let {
                Box(Modifier.align(Alignment.CenterEnd)) {
                    IconButton(
                        onClick = onRightIconClick,
                        modifier = Modifier,
                    ) {
                        Icon(
                            painter = painterResource(it),
                            contentDescription = stringResource(R.string.navigation_icon_label),
                            tint = MaterialTheme.colors.onPrimary
                        )
                    }
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNavBar() {
    NavBar(
        { Text(stringResource(R.string.image_list_title)) },
        leftIcon = R.drawable.ic_back,
        rightIcon = null,
        {},
        {})
}