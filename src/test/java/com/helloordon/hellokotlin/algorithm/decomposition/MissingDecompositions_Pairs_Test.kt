package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import com.helloordon.hellokotlin.dto.pair
import org.junit.Test

class MissingDecompositions_Pairs_Test {

    @Test
    fun shouldFindNoMissingPairs() {
        verifyFoundPairs(emptyList(), 2, listOf(listOf(0, 1)))
    }

    @Test
    fun shouldFindOneMissingPair() {
        verifyFoundPairs(listOf(pair(0, 1)), 2, emptyList())
    }

    @Test
    fun shouldFindAllMissingPairs() {
        verifyFoundPairs(listOf(pair(0, 1), pair(0, 2)), 3, listOf(listOf(1, 2)))
        verifyFoundPairs(listOf(pair(0, 1), pair(0, 2), pair(1, 2)), 3, emptyList())
    }

    private fun verifyFoundPairs(expected: List<Argument>, argumentsCount: Int, pairs: List<List<Int>>) {
        allPairs(argumentsCount)
                .findMissingDecompositions(pairs)
                .test()
                .assertValueSequence(expected)
    }
}


