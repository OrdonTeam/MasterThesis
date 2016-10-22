package com.helloordon.hellokotlin.algorithm.decomposition

import org.junit.Assert
import org.junit.Test

class MatrixDiscernibility_Groups_Test {

    @Test
    fun shouldFindMatrixDiscernibilityForTwoGroups() {
        assertMatrixDiscernibility(
                listOf(listOf()),
                listOf(
                        listOf(listOf(true)),
                        listOf(listOf(true))))
        assertMatrixDiscernibility(
                listOf(listOf(0)),
                listOf(
                        listOf(listOf(true)),
                        listOf(listOf(false))))
        assertMatrixDiscernibility(
                listOf(listOf(1)),
                listOf(
                        listOf(listOf(true, true)),
                        listOf(listOf(true, false))))
    }

    @Test
    fun shouldFindMatrixDiscernibilityForThreeGroups() {
        assertMatrixDiscernibility(
                listOf(listOf(0), listOf(1), listOf(0, 1)),
                listOf(
                        listOf(listOf(true, true)),
                        listOf(listOf(false, true)),
                        listOf(listOf(true, false))))
    }

    private fun assertMatrixDiscernibility(expected: List<List<Int>>, groups: List<List<List<Boolean>>>) {
        Assert.assertEquals(expected, findMatrixDiscernibility(groups))
    }
}