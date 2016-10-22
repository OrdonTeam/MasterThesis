package com.helloordon.hellokotlin.algorithm.reduction

import org.junit.Assert
import org.junit.Test

class ReductionTest {

    @Test
    fun shouldFindBestArgumentToReduction() {
        verifyBestArgument(0, listOf(listOf(0)), 1)
        verifyBestArgument(1, listOf(listOf(1)), 2)
    }

    private fun verifyBestArgument(expected: Int, discernibility: List<List<Int>>, attributesCount: Int) {
        Assert.assertEquals(expected, findBestArgumentToReduction(discernibility, attributesCount))
    }

    private fun findBestArgumentToReduction(discernibility: List<List<Int>>, attributesCount: Int): Int {
        return discernibility.first().first()
    }
}