package com.helloordon.hellokotlin

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

    private fun assertMatrixDiscernibility(a: List<List<Boolean>>, b: List<List<Boolean>>, discernibility: List<List<Int>>) {
        Assert.assertEquals(discernibility, findMatrixDiscernibility(a, b))
    }

    private fun findMatrixDiscernibility(groupA: List<List<Boolean>>, groupB: List<List<Boolean>>): List<List<Int>> {
        return listOf(findDiscernibility(groupA[0], groupB[0]))
    }
}