package com.valerunners.tcgdeckbuilder.ui.compose.scryfall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.valerunners.tcgdeckbuilder.viewmodels.scryfall.random.ScryfallRandomViewModel
import com.valerunners.tcgdeckbuilder.viewmodels.scryfall.random.ScryfallRandomViewModelFactory
import com.valerunners.tcgdeckbuilder.repos.Resource
import com.valerunners.tcgdeckbuilder.repos.scryfall.ScryfallApiRepository

@Composable
fun RandomCardView(modifier: Modifier = Modifier){
    val repository = ScryfallApiRepository()
    val factory = ScryfallRandomViewModelFactory(repository)
    val scryfallViewModel: ScryfallRandomViewModel = viewModel(factory = factory)

    val scryfallState = scryfallViewModel.card.observeAsState()
    LaunchedEffect(Unit) {
        scryfallViewModel.getRandomCard()
    }

    when (val state = scryfallState.value) {
        is Resource.Success -> {
//            state.data?.let { SmallViewCard(it) }
        }

        is Resource.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Loading!!!!",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                    )
                )
            }
        }

        is Resource.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Error: ${state.message ?: "Unknown"}",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                    )
                )
            }
        }

        else -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ) {
                Text(
                    text = "Not working",
                    style = TextStyle(
                        fontStyle = FontStyle.Italic,
                    )
                )
            }
        }
    }
}