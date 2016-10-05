package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class FindMissingFoursTest {

    @Test
    fun shouldFindNoMissingFours() {
        verifyFoundMissingFours(emptyList(), emptyList(), emptyList())
    }

    private fun verifyFoundMissingFours(expected: List<Pair<List<Int>, List<Int>>>,
                                        separatePairs: List<Pair<List<Int>, List<Int>>>,
                                        discernibility: List<List<Int>>) {
        Assert.assertEquals(expected, findMissingFours(discernibility, separatePairs))
    }

    private fun findMissingFours(discernibility: List<List<Int>>, separatePairs: List<Pair<List<Int>, List<Int>>>): List<Pair<List<Int>, List<Int>>> {
        return emptyList()
    }
}