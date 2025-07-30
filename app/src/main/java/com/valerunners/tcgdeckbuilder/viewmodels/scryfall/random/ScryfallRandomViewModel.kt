package com.valerunners.tcgdeckbuilder.viewmodels.scryfall.random

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valerunners.tcgdeckbuilder.ScryfallCard
import com.valerunners.tcgdeckbuilder.repos.Resource
import com.valerunners.tcgdeckbuilder.repos.scryfall.ScryfallApiRepository
import kotlinx.coroutines.launch

class ScryfallRandomViewModel(private val repository: ScryfallApiRepository): ViewModel() {
    private val _card = MutableLiveData<Resource<ScryfallCard>>()
    val card: LiveData<Resource<ScryfallCard>> get() = _card

    fun getRandomCard(){
        _card.value = Resource.Loading()
        viewModelScope.launch {
            _card.value = repository.getRandomCard()
        }
    }
}