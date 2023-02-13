package com.example.test.viewModels

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BonusesViewModel : ViewModel() {
    private val _message = MutableLiveData("")
    private val message: LiveData<String> = _message

    fun setMessage(message: String)
    {
        _message.value = message
    }

    fun getMessage() : LiveData<String>
    {
        return message
    }


}