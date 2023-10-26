package com.example.basics.calculator

interface CalculatorInterface<T> {

    fun sum(number1: T, number2: T) : T
    fun multiplication(number1: T, number2: T) : T

}