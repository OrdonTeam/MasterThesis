package com.helloordon.hellokotlin.algorithm

import org.junit.Assert
import org.junit.Test

class SeparateFoursTest {

    @Test
    fun shouldFindNoSeparateFours() {
        verify(emptyList(), listOf(listOf(0, 1) to listOf(2, 3)))
    }

    private fun verify(expected: List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>, collections: List<Pair<List<Int>, List<Int>>>) {
        Assert.assertEquals(expected, getSeparateFours(collections))
    }
}
