package com.example.numbersfactapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val _factText: MutableLiveData<String> = MutableLiveData()
    val factText: LiveData<String> = _factText
    fun getFact(number: Int){
        viewModelScope.launch {
            val numberFact = NumbersApi.retrofitService.getFact(number)
            _factText.postValue(numberFact.text)
        }
    }

    fun getRandomFact(){
        viewModelScope.launch {
            val numberFact = NumbersApi.retrofitService.getRandomFact()
            _factText.postValue((numberFact.text))
        }
    }
}