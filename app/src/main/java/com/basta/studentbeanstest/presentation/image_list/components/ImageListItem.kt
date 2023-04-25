package com.basta.studentbeanstest.presentation.image_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.basta.studentbeanstest.R
import com.basta.studentbeanstest.domain.models.Photo

@Composable
fun ImageListItem(photo: Photo) {
    Row(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .defaultMinSize(minHeight = 100.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.secondary),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = CenterVertically
    ) {

        AsyncImage(
            model = photo.thumbnailUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = photo.title,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.onBackground,
            modifier = Modifier
                .align(CenterVertically)
                .padding(horizontal = 10.dp)
        )
    }
}