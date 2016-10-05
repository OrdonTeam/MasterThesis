package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class FindMissingFoursTest {

    @Test
    fun shouldFindNoMissingFours() {
        verifyFoundMissingFours(
                emptyList(),
                emptyList(),
                emptyList())
    }

    @Test
    fun shouldFindMissingFour() {
        verifyFoundMissingFours(
                listOf(listOf(0, 4) to listOf(2, 3)),
                listOf(listOf(0, 4) to listOf(2, 3)),
                emptyList())
    }

    private fun verifyFoundMissingFours(expected: List<Pair<List<Int>, List<Int>>>,
                                        separatePairs: List<Pair<List<Int>, List<Int>>>,
                                        discernibility: List<List<Int>>) {
        Assert.assertEquals(expected, findMissingFours(discernibility, separatePairs))
    }

    private fun findMissingFours(discernibility: List<List<Int>>, separatePairs: List<Pair<List<Int>, List<Int>>>): List<Pair<List<Int>, List<Int>>> {
        return separatePairs
    }
}