package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import org.junit.Test

class MissingDecompositions_Triplets_Test {

    @Test
    fun shouldFindNoMissingTriplets() {
        verifyFoundPairs(emptyList(), 3, listOf(listOf(0, 1, 2)))
    }

    private fun verifyFoundPairs(expected: List<Argument>, argumentsCount: Int, discernibility: List<List<Int>>) {
        allTriplets(argumentsCount)
                .findMissingDecompositions(discernibility)
                .test()
                .assertValueSequence(expected)
    }
}