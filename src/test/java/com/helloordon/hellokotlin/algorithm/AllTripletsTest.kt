package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import org.junit.Test

class AllTripletsTest {

    @Test
    fun shouldReturnNoTriplets() {
        verify(emptyList(), 1)
        verify(emptyList(), 2)
    }

    private fun verify(expected: List<Argument>, argumentCount: Int) {
        allTriplets(argumentCount)
                .test()
                .assertValueSequence(expected)
    }
}
