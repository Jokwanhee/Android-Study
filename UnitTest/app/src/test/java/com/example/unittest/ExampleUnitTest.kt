package com.example.unittest

import android.util.Log
import org.junit.Test

import org.junit.Assert.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class ExampleUnitTest {
    /** Use Mock Unit Test */
    /** Mock 클래스 객체 생성 */
    @Mock
    private lateinit var animal: Animal

    @Test
    fun mockTest(){
        animal = Animal("jo", 1, true, listOf("1"))
        /** 객체 생성 */
        MockitoAnnotations.initMocks(animal)
        assertTrue(animal != null)
    }

    /** Use JUnit Unit Test */
//    private var calculator: Calculator = Calculator()
//
//    @Test
//    fun junitTest() {
//        assertEquals(50, calculator.addValue(10,40))
//        assertEquals(10, calculator.addValue(10,40))
//        val arr = arrayOf(1,2,3,4)
//        assertArrayEquals(arr, calculator.addArray(arrayOf(1,2,3), 3))
//    }

}