package com.helloordon.hellokotlin.algorithm.decomposition

import org.junit.Test

class ListOfSetsTest {

    @Test
    fun shouldReturnEmpty() {
        assertEquals(expected = emptyList(), givenN = 1)
    }

    @Test
    fun shouldReturnAllPairs() {
        assertEquals(expected = listOf(listOf(0, 1)), givenN = 2)
    }

    @Test
    fun shouldReturnAllPairsAndTriples() {
        assertEquals(expected = listOf(listOf(0, 1), listOf(0, 2), listOf(1, 2), listOf(0, 1, 2)), givenN = 3)
    }

    @Test
    fun shouldReturnAllPairsTriplesAndFours() {
        assertEquals(expected = listOf(
                listOf(0, 1), listOf(0, 2), listOf(0, 3),
                listOf(1, 2), listOf(1, 3), listOf(2, 3),
                listOf(0, 1, 2), listOf(0, 1, 3), listOf(0, 2, 3), listOf(1, 2, 3),
                listOf(0, 1, 2, 3)), givenN = 4)
    }

    private fun assertEquals(expected: List<List<Int>>, givenN: Int) {
        listOfSets(givenN).test()
            .assertValueSequence(expected)
    }
}

