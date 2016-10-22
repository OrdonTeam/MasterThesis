package com.helloordon.hellokotlin.algorithm.reduction

import org.junit.Assert
import org.junit.Test

class ReductionTest {

    @Test
    fun shouldFindBestArgumentToReduction() {
        val discernibility = listOf(listOf(0))
        val attributesCount = 1
        val expected = 0
        verifyBestArgument(expected, discernibility, attributesCount)
    }

    private fun verifyBestArgument(expected: Int, discernibility: List<List<Int>>, attributesCount: Int) {
        Assert.assertEquals(expected, findBestArgumentToReduction(discernibility, attributesCount))
    }

    private fun findBestArgumentToReduction(discernibility: List<List<Int>>, attributesCount: Int): Int {
        return 0
    }
}