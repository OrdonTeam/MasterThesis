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

    private fun findBestArgumentToReduction(discernibility: List<List<Int>>): Int {
        val minDiscernibilityLength = discernibility.minBy { it.count() }!!.count()
        val candidates = discernibility.filter { it.count() == minDiscernibilityLength }.flatMap { it }
        val countInColumns = discernibility.flatMap { it }.groupBy { it }.mapValues { it.value.count() }
        return countInColumns.filter { candidates.contains(it.key) }.maxBy { it.value }!!.key
    }

    private fun removeRowsFromDiscernibility(discernibility: List<List<Int>>, argument: Int): List<List<Int>> {
        return discernibility.filterNot { it.contains(argument) }
    }

    private fun findReduct(discernibility: List<List<Int>>): List<Int> {
        if (discernibility.isEmpty()) return emptyList()
        val bestArgument = findBestArgumentToReduction(discernibility)
        return (findReduct(removeRowsFromDiscernibility(discernibility, bestArgument)) + bestArgument).sorted()
    }

}