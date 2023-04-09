package com.practice.calculator.ver1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculatorViewModel: ViewModel() {
    private val calculator = Calculator()

    // MutableLiveData 객체를 생성한다.
    // 데이터를 변경할 수 있는 변수를 선언한다.(MutableLiveData)
    private var _result = MutableLiveData<Int>()
    // LiveData
    // MutableLiveData 데이터의 변경을 관찰하여, 변경이 일어났을 때
    // 바뀐 값을 할당(getter를 통해)받는 객체를 생성한다.
    val result: LiveData<Int>
        get() = _result

    fun calculate(num1: String, num2: String) {
        val a = num1.toInt()
        val b = num2.toInt()

        val res = calculator.add(a, b)

        // 결괏값은 MutableLiveData에 바로 할당하면 안된다.
        // MutableData의 '값'에 접근하여 변경하기 위하여 .value
        // 새로운 값인 res가 할당되면, 해당 변경 사항이
        // ViewModel에 의해 LiveData 객체에 자동으로 전달된다.
        _result.value = res
    }
}