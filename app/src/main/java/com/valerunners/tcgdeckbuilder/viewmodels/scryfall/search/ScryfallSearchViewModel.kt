package com.valerunners.tcgdeckbuilder.viewmodels.scryfall.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valerunners.tcgdeckbuilder.ScryfallBaseData
import com.valerunners.tcgdeckbuilder.repos.Resource
import com.valerunners.tcgdeckbuilder.repos.scryfall.ScryfallApiRepository
import kotlinx.coroutines.launch

class ScryfallSearchViewModel(private val repository: ScryfallApiRepository): ViewModel() {
    private val _cards = MutableLiveData<Resource<ScryfallBaseData>>()
    val cards: LiveData<Resource<ScryfallBaseData>> get() = _cards

    fun getSearchCards(searchQuery: String){
        _cards.value = Resource.Loading()
        viewModelScope.launch {
            _cards.value = repository.getSearch(searchQuery)
        }
    }
}