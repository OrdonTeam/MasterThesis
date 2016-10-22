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

    private fun verifyBestArgument(expected: Int, discernibility: List<List<Int>>) {
        Assert.assertEquals(expected, findBestArgumentToReduction(discernibility))
    }

    private fun findBestArgumentToReduction(discernibility: List<List<Int>>): Int {
        val minDiscernibilityLength = discernibility.minBy { it.count() }!!.count()
        val candidates = discernibility.filter { it.count() == minDiscernibilityLength }.flatMap { it }
        val countInColumns = discernibility.flatMap { it }.groupBy { it }.mapValues { it.value.count() }
        return countInColumns.filter { candidates.contains(it.key) }.maxBy { it.value }!!.key
    }
}