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

    @Test
    fun shouldReturnFourTriplets() {
        verify(listOf(triplet(0, 1, 2), triplet(0, 1, 3), triplet(0, 2, 3), triplet(1, 2, 3)), 4)
    }

    @Test
    fun shouldReturnTripletsFor5() {
        verify(listOf(
                triplet(0, 1, 2), triplet(0, 1, 3), triplet(0, 1, 4), triplet(0, 2, 3), triplet(0, 2, 4),triplet(0, 3, 4),
                triplet(1, 2, 3), triplet(1, 2, 4), triplet(1, 3, 4),
                triplet(2, 3, 4)), 5)

    }

    private fun verify(expected: List<Argument>, argumentsCount: Int) {
        allTriplets(argumentsCount)
                .test()
                .assertValueSet(expected)
                .assertValueCount(expected.size)
    }
}
