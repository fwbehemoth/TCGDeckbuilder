package com.valerunners.tcgdeckbuilder.ui.compose.scryfall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage

@Composable
fun LargeViewCard(name: String, imageUrl: String) {
    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(
            model = imageUrl,
            contentDescription = name ?: "Empty",
            modifier = Modifier.align(alignment = Alignment.Center)
        )
    }
}
