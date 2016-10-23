package com.helloordon.hellokotlin.algorithm.reduction

import org.junit.Assert
import org.junit.Test

class ReductionTest {

    @Test
    fun shouldFindBestArgumentToReduction() {
        verifyBestArgument(0, listOf(listOf(0)))
        verifyBestArgument(1, listOf(listOf(1)))
        verifyBestArgument(0, listOf(listOf(1), listOf(0), listOf(0)))
        verifyBestArgument(2, listOf(listOf(0, 1, 2), listOf(0, 1), listOf(2)))
    }

    @Test
    fun shouldRemoveRowsByArgument() {
        Assert.assertEquals(emptyList<Int>(), removeRowsFromDiscernibility(listOf(listOf(0)), 0))
        Assert.assertEquals(listOf(listOf(0)), removeRowsFromDiscernibility(listOf(listOf(0)), 1))
    }

    @Test
    fun shouldFindReduct() {
        Assert.assertEquals(listOf(0), findReduct(listOf(listOf(0, 1), listOf(0, 2))))
        Assert.assertEquals(listOf(1), findReduct(listOf(listOf(0, 1), listOf(1, 2))))
        Assert.assertEquals(listOf(1, 2), findReduct(listOf(listOf(1), listOf(2))))
    }

    private fun verifyBestArgument(expected: Int, discernibility: List<List<Int>>) {
        Assert.assertEquals(expected, findBestArgumentToReduction(discernibility))
    }
}
