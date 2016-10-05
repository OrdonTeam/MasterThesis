package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.algorithm.getMissingFours
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

    @Test
    fun shouldFilterOurFour() {
        verifyFoundMissingFours(
                emptyList(),
                listOf(listOf(0, 4) to listOf(2, 3)),
                listOf(listOf(0, 2, 3, 4)))
    }

    private fun verifyFoundMissingFours(expected: List<Pair<List<Int>, List<Int>>>,
                                        separatePairs: List<Pair<List<Int>, List<Int>>>,
                                        discernibility: List<List<Int>>) {
        Assert.assertEquals(expected, getMissingFours(discernibility, separatePairs))
    }
}
