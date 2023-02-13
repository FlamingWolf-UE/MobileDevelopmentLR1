package com.example.test.viewModels
 
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ShopActivityViewModel : ViewModel() {
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

    fun buyItem(cost : Int, reward : Int) :Boolean
    {
        if (_counter.value!! >= cost )
        {
            _buster.value = _buster.value?.plus(reward)
            _counter.value = _counter.value?.plus(-cost)
            return true
        }
        return false

    }



}