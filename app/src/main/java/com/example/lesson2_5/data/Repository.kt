package com.example.lesson2_5.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    fun makeRequest(firstName: String, secondName: String): LiveData<CalculateModel> {
        val liveData = MutableLiveData<CalculateModel>()
        App.api.getPercentage(firstName,secondName).enqueue(
            object : Callback<CalculateModel> {
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>
                ) {
                    liveData.postValue(response.body())
                }

                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    Log.d("TAG", "onFailure: ${t.stackTrace}")
                }
            }
        )
        return liveData
    }
}