package com.example.test.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel : ViewModel() {
    private val _counter = MutableLiveData(0)
    private val counter: LiveData<Int> = _counter
    private val _buster = MutableLiveData(0)
    private val buster: LiveData<Int> = _buster

    fun setBuster(buster : Int) : Unit
    {
        _buster.value = buster
    }

    fun getBuster() : LiveData<Int>
    {
        return buster
    }

    fun setCounter(counter : Int) : Unit
    {
        _counter.value = counter
    }

    fun getCounter() : LiveData<Int>
    {
        return counter
    }

    fun incrementCount() : Unit
    {
        _counter.value = _counter.value?.plus(1 + buster.value!!)
    }





}