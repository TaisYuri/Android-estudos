package com.example.basics.calculator

class CalculatorFloatImpl: CalculatorInterface<Float> {
    override fun sum(number1: Float, number2: Float) = number1 + number2

    override fun multiplication(number1: Float, number2: Float) = number1 * number2


}