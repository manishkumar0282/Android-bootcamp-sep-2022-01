package com.programmingwithmanish.kotlinbasics

fun main() {
    try {
        print(5/0)
    } catch (ex:ArithmeticException) {
        print("You hit an exception")
    }
}

