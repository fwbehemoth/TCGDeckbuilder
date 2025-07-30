package com.valerunners.tcgdeckbuilder.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel:ViewModel() {
    private val _appBarTitle = MutableLiveData("TCG Deck Builder")
    val appBarTitle: MutableLiveData<String> get() = _appBarTitle

    fun updateAppBarTitle(newTitle: String){
        _appBarTitle.value = newTitle
    }
}