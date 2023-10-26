package com.example.basics

import com.example.basics.calculator.CalculatorFloatImpl
import com.google.common.truth.Truth
import org.junit.Before
import org.junit.Test

class CalculatorFloatImplTest {

    lateinit var calcFloatImpl: CalculatorFloatImpl

    @Before
    fun setup(){
        calcFloatImpl = CalculatorFloatImpl()
    }

    @Test
    fun sum_whenReceivingNumber4fand3f_thenResult7f(){
        //given
        val number1 = 4.5f
        val number2 = 3.3f

        //when
        val result = calcFloatImpl.sum(number1, number2)

        //Then
        Truth.assertThat(result).isEqualTo(7.8f)
    }

    @Test
    fun multiplication_whenReceivingNumber4fand3f_thenResult13f(){
        val number1 = 4.0f
        val number2 = 3.3f

        val result = calcFloatImpl.multiplication(number1, number2)

        Truth.assertThat(result).isEqualTo(13.2f)
    }
}