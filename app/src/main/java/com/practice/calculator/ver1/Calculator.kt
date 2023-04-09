package com.practice.calculator.ver1

class Calculator {
    // 비즈니스 로직을 처리하는 모델이다.
    var result: Int = 0

    fun add(a: Int, b: Int): Int {
        result = a + b
        return result
    }
}
