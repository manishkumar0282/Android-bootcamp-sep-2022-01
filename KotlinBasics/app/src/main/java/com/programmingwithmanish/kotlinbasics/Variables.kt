package com.programmingwithmanish.kotlinbasics

fun main() {
// Variables are defined using the var keyword
//    var countOfVisitors = 10;
//    // countOfVisitors is a variable whose value is 10
//    countOfVisitors = 8;
//    print("The value of variable is "+countOfVisitors)
//
//    // Constants are defined using val
//    val myCount = 10
//    val pi = 3.14
//    // pi = 2.14 will result in an error of reassignment
//    print("The value of variable is "+myCount)


//    var x = true
//    x = 10
//    print(x)

    // DataTypes

    // 1.Number
//    val byteNum = 2 // Byte 8 bit -2^(8-1) to 2^(8-1) - 1 ==== -128 to 127
//    val shortNum = 1 // Short size is 16 bits -2^15 to 2^15 - 1 ==== -32768 to 32767
    val intNum  = 10000 // Int size is 32 bit -2^31 to 2^31 - 1 ====
    val longNum = 123412341234 // Long size is 64 bit -2^63 to 2^63 - 1 ====

    // small
    // comment/ uncomment === ctrl+/

//    val a = 5
//    val b = 7
//    val c = a+b
//    print(c)
//
//    // Double & Float
//    // 64       32
//    // Decimal numbers
//
//    val decNum = 1.25
//    val anotherDecNum = 1231234234123.1234122313412324
//
//    val qwer: Short = 1
//
//    // Float (32) is smaller than double(64)
//     var floatNum:Double = 1.2
//
//
////    Char stands for character takes 4 bit to store
//    var c = 'g'
//    var g = "asdf"

    var fname = "Manish"
    var lname = "Kumar"
    // My name is Manish Kumar

    // String Interpolation
    // replace some symbol by the value of variable
    print("My name is \n $fname \t $lname")

    val isItCloudyToday = true

    // Int, Long, Double, Float, String, Boolean

    // Create different types of variables for Int, Double and perform addition, subtraction
}
