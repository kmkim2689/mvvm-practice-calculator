package com.practice.calculator

import android.media.VolumeShaper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    private val calculator = Calculator()

    private var _result = MutableLiveData<Int>()
    val result: LiveData<Int>
        get() = _result

    fun calculate(num1: String, num2: String) {
        val a = num1.toInt()
        val b = num2.toInt()

        val res = calculator.add(a, b)

        _result.value = res
    }
}