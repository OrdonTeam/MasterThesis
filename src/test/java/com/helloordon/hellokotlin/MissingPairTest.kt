package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class MissingPairTest {

    @Test
    fun shouldFindNoMissingPairs() {
        verifyFoundPairs(emptyList(), 2, listOf(listOf(0, 1)))
    }

    private fun verifyFoundPairs(expected: List<Int>, argumentsCount: Int, pairs: List<List<Int>>) {
        Assert.assertEquals(expected, getMissingPairs(argumentsCount, pairs))
    }

}

fun getMissingPairs(argumentsCount: Int, pairs: List<List<Int>>): List<Int> {
    return emptyList()
}
