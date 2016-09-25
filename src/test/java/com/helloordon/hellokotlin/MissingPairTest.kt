package com.helloordon.hellokotlin

import org.junit.Assert
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

    private fun verifyFoundPairs(expected: List<List<Int>>, argumentsCount: Int, pairs: List<List<Int>>) {
        Assert.assertEquals(expected, getMissingPairs(argumentsCount, pairs))
    }

}

fun getMissingPairs(argumentsCount: Int, pairs: List<List<Int>>): List<List<Int>> {
    val list = (0..0).flatMap { first ->
        (1..1).map { second ->
            listOf(first, second)
        }
    }
    return list.filter {
        !pairs.contains(it)
    }
}
