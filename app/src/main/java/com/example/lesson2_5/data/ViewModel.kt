package com.example.lesson2_5.data

import androidx.lifecycle.LiveData

class ViewModel : androidx.lifecycle.ViewModel() {

    private val repository = Repository()

    fun makeRequest(firstName: String, secondName: String) : LiveData<CalculateModel> {
        return repository.makeRequest(firstName, secondName)
    }
}