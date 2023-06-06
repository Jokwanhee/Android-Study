package com.example.unittest

class Calculator() {
    fun addValue(a: Int, b: Int): Int =  a + b
    fun addArray(arr: Array<Int>, a: Int): Array<Int>{
        for (i in 0..arr.size){
            arr[i] += a
        }
        return arr
    }
}