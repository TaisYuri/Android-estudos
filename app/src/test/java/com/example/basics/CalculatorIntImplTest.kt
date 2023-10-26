package com.example.basics

import com.example.basics.calculator.CalculatorIntImpl
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class CalculatorIntImplTest {

    lateinit var calcIntImpl: CalculatorIntImpl

    @Before
    fun setup(){
        calcIntImpl = CalculatorIntImpl()
    }

    @Test
    fun sum_whenReceivingNumber2and3_thenResult5(){
        //given
        val number1 = 2
        val number2 = 3

        //when
        val result = calcIntImpl.sum(number1, number2)

        //Then
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun multiplication_whenReceivingNumber2and3_thenResult6(){
        val number1 = 2
        val number2 = 3

        val result = calcIntImpl.multiplication(number1, number2)

        assertThat(result).isEqualTo(6)
    }
}