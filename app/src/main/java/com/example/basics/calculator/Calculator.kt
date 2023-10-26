package com.example.basics.calculator

enum class Operations{
    SUM, MULTIPLICATION
}

class Calculator(
    private val calcInt: CalculatorIntImpl, private val calcFloat: CalculatorFloatImpl
) {

    fun calculate(operations: Operations, number1: Number, number2: Number): Number{
        return if(number1 is Int && number2 is Int){
            when(operations){
                Operations.SUM -> calcInt.sum(number1, number2)
                Operations.MULTIPLICATION -> calcInt.multiplication(number1, number2)
            }
        }else if(number1 is Float && number2 is Float){
            when(operations){
                Operations.SUM -> calcFloat.sum(number1, number2)
                Operations.MULTIPLICATION -> calcFloat.multiplication(number1, number2)
            }
        }else{
            throw Exception("Operação invalida")
        }
    }

}