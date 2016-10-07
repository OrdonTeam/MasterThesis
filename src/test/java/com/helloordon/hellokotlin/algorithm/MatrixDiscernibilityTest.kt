package com.helloordon.hellokotlin.algorithm

import org.junit.Assert
import org.junit.Test

class MatrixDiscernibilityTest {

    @Test
    fun shouldFindMatrixDiscernibilityForTwoRows() {
        assertMatrixDiscernibility(
                listOf(listOf(true)),
                listOf(listOf(true)),
                listOf(listOf()))
        assertMatrixDiscernibility(
                listOf(listOf(true)),
                listOf(listOf(false)),
                listOf(listOf(0)))
        assertMatrixDiscernibility(
                listOf(listOf(true, true)),
                listOf(listOf(true, false)),
                listOf(listOf(1)))
    }

    @Test
    fun shouldFindMatrixDiscernibilityForMultipleRows() {
        assertMatrixDiscernibility(
                listOf(listOf(true, false), listOf(false, true)),
                listOf(listOf(false, false)),
                listOf(listOf(0), listOf(1)))
    }

    private fun assertMatrixDiscernibility(a: List<List<Boolean>>, b: List<List<Boolean>>, discernibility: List<List<Int>>) {
        Assert.assertEquals(discernibility, findMatrixDiscernibility(a, b))
    }
}