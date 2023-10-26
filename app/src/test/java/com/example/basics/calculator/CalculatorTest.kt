package com.example.basics.calculator

import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.junit4.MockKRule
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CalculatorTest {
    @get:Rule
    val mockKRule = MockKRule(this)

    private lateinit var calc: Calculator

    @MockK
    lateinit var calcIntMock: CalculatorIntImpl
    @MockK
    lateinit var calcFloatMock: CalculatorFloatImpl


    @Before
    fun setup(){

        //INFORMA OS VALORES QUE O MOCK DEVE RETORNAR
        every{
            calcIntMock.sum(any(), any())
        }returns 0

        every{
            calcFloatMock.multiplication(any(), any())
        }returns 0f

        calc = Calculator(calcIntMock, calcFloatMock)
    }

    @Test
    fun operation_whenSum_AndTwoNumbersInt_thenShoudCallCalcInt(){
        val number1 = 2
        val number2 = 3
        val operation = Operations.SUM

        calc.calculate(operation, number1, number2)

        verify(exactly = 1) {
            calcIntMock.sum(number1, number2)
        }
    }

    @Test
    fun operation_whenMultiplication_AndTwoNumbersFloat_thenShoudCallCalcMultiplication(){
        val number1 = 2.5f
        val number2 = 3.5f
        val operation = Operations.MULTIPLICATION

        calc.calculate(operation, number1, number2)

        verify(exactly = 1) {
            calcFloatMock.multiplication(number1, number2)
        }
    }

    @Test(expected = Exception::class)
    fun operation_whenSum_andTwoNumbersDouble_thenShouldException(){
        val number1 = 2.5
        val number2 = 3.5
        val operation = Operations.SUM

        calc.calculate(operation, number1, number2)
    }
}