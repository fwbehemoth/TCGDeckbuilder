package com.valerunners.tcgdeckbuilder.ui.compose.scryfall

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.valerunners.tcgdeckbuilder.viewmodels.scryfall.search.ScryfallSearchViewModel
import com.valerunners.tcgdeckbuilder.viewmodels.scryfall.search.ScryfallSearchViewModelFactory
import com.valerunners.tcgdeckbuilder.repos.Resource
import com.valerunners.tcgdeckbuilder.repos.scryfall.ScryfallApiRepository

@Composable
fun SmallCardListView(navController: NavController, innerPadding: PaddingValues){
    val repository = ScryfallApiRepository()
    val factory = ScryfallSearchViewModelFactory(repository)
    val scryfallViewModel: ScryfallSearchViewModel = viewModel(factory = factory)

    val scryfallState = scryfallViewModel.cards.observeAsState()
    LaunchedEffect(Unit) {
        scryfallViewModel.getSearchCards("/cards/search?q=c%3Am+id%3Agruul+t%3Acreature")
    }

    when (val state = scryfallState.value) {
        is Resource.Success -> {
            LazyColumn(
                modifier = Modifier.fillMaxHeight().padding(innerPadding),
            ) {
                items (items = state.data?.Data!!, itemContent = {
                    item -> (
                        if (!item.name!!.startsWith("A-")) {
                            SmallViewCard(item, navController, innerPadding)
                        } else {

                        })
                })
            }
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