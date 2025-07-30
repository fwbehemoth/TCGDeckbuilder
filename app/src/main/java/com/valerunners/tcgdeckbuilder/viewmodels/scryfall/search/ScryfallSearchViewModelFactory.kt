package com.valerunners.tcgdeckbuilder.viewmodels.scryfall.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.valerunners.tcgdeckbuilder.repos.scryfall.ScryfallApiRepository

class ScryfallSearchViewModelFactory(private val repository: ScryfallApiRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScryfallSearchViewModel::class.java)) {
            return ScryfallSearchViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}