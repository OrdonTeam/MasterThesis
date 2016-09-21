package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class MatrixDiscernibilityTest {

    @Test
    fun shouldFindEmptyMatrixDiscernibilityForTwoRows() {
        assertMatrixDiscernibility(
                listOf(listOf(true)),
                listOf(listOf(true)),
                listOf(listOf()))
    }

    private fun assertMatrixDiscernibility(a: List<List<Boolean>>, b: List<List<Boolean>>, discernibility: List<List<Int>>) {
        Assert.assertEquals(discernibility, findMatrixDiscernibility(a, b))
    }

    private fun findMatrixDiscernibility(groupA: List<List<Boolean>>, groupB: List<List<Boolean>>): List<List<Int>> {
        return listOf(emptyList())
    }
}