package com.helloordon.hellokotlin.algorithm

import org.junit.Test

class MissingPairTest {

    @Test
    fun shouldFindNoMissingPairs() {
        verifyFoundPairs(emptyList(), 2, listOf(listOf(0, 1)))
    }

    @Test
    fun shouldFindOneMissingPair() {
        verifyFoundPairs(listOf(listOf(0, 1)), 2, emptyList())
    }

    @Test
    fun shouldFindAllMissingPairs() {
        verifyFoundPairs(listOf(listOf(0, 1), listOf(0, 2)), 3, listOf(listOf(1, 2)))
        verifyFoundPairs(listOf(listOf(0, 1), listOf(0, 2), listOf(1, 2)), 3, emptyList())
    }

    private fun verifyFoundPairs(expected: List<List<Int>>, argumentsCount: Int, pairs: List<List<Int>>) {
        pairs.toMissingPairs(argumentsCount)
                .test()
                .assertValueSequence(expected)
    }
}


