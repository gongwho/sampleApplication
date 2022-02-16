package com.example.loginsampleapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) :
    ViewModel() {

    private val NUM_KEY = "num"

    val num: MutableLiveData<Int> =
        if (savedStateHandle.contains(NUM_KEY))
            savedStateHandle.getLiveData(NUM_KEY)
        else
            MutableLiveData(0)

    fun add() {
        num.value = num.value?.plus(1)
        saveNum()
    }

    private fun saveNum() {
        savedStateHandle[NUM_KEY] = num.value ?: 0
    }
}
