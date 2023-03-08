package com.example.lesson2_5.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class CalculateModel(
    @SerializedName("fname")
    val firstName: String,
    @SerializedName("sname")
    val secondName: String,
    val percentage: String,
    val result: String
    ) : Serializable