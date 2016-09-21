package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class ExampleFunctionTest {

    @Test
    fun shouldCalculateCpq() {
        val zeroRows = listOf(
                listOf(0, 0, 0, 0, 0),
                listOf(0, 0, 1, 1, 1),
                listOf(0, 1, 0, 1, 0),
                listOf(0, 1, 1, 1, 1),
                listOf(0, 1, 1, 0, 0)).toBoolean()
        val oneRows = listOf(
                listOf(0, 0, 0, 1, 1),
                listOf(0, 1, 0, 0, 0),
                listOf(0, 1, 1, 0, 1),
                listOf(1, 1, 0, 1, 0),
                listOf(1, 0, 0, 1, 1),
                listOf(1, 0, 0, 1, 0)).toBoolean()
        Assert.assertTrue(
                findMatrixDiscernibility(zeroRows, oneRows).filter { it.size == 2 }.containsAll(
                        listOf(listOf(3, 4), listOf(0, 3), listOf(1, 3), listOf(0, 2), listOf(1, 4), listOf(0, 1), listOf(1, 2))
                ))
    }

    private fun List<List<Int>>.toBoolean() = map { it.map { if (it == 0) false else true } }
}

