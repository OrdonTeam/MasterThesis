package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import com.helloordon.hellokotlin.dto.triplet
import org.junit.Test

class AllTripletsTest {

    @Test
    fun shouldReturnNoTriplets() {
        verify(emptyList(), 1)
        verify(emptyList(), 2)
    }

    @Test
    fun shouldReturnOneTriplet() {
        verify(listOf(triplet(0, 1, 2)), 3)
    }

    private fun verify(expected: List<Argument>, argumentsCount: Int) {
        allTriplets(argumentsCount)
                .test()
                .assertValueSequence(expected)
    }
}
