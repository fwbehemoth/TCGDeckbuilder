package com.valerunners.tcgdeckbuilder.viewmodels.scryfall.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.valerunners.tcgdeckbuilder.repos.scryfall.ScryfallApiRepository

class ScryfallRandomViewModelFactory(private val repository: ScryfallApiRepository): ViewModelProvider.Factory {
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(ScryfallRandomViewModel::class.java)) {
            return ScryfallRandomViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}