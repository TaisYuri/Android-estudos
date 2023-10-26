package com.example.basics.calculator

class CalculatorIntImpl: CalculatorInterface<Int> {
    override fun sum(number1: Int, number2: Int) = number1 + number2

    override fun multiplication(number1: Int, number2: Int)= number1 * number2
}