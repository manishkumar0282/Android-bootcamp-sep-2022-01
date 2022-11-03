package com.programmingwithmanish.kotlinbasics

fun main() {
    demo(5)
    demo("Manish")
}

fun demo(x:Any) {
    if(x is Int) {
        println("integer")
    }
    if(x is String) {
        println("String")
    }
}

