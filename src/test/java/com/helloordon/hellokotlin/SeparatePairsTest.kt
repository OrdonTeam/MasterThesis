package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class SeparatePairsTest {

    @Test
    fun shouldFindNoSeparatePairs() {
        verify(emptyList(), listOf(listOf(0, 1)))
    }

    @Test
    fun shouldFindOneSeparatePair() {
        verify(listOf(listOf(0, 1) to listOf(2, 3)), listOf(listOf(0, 1), listOf(2, 3)))
    }

    @Test
    fun shouldNotFindNotSeparatePair() {
        verify(emptyList(), listOf(listOf(0, 1), listOf(1, 2)))
    }

    private fun verify(expected: List<Pair<List<Int>, List<Int>>>, collections: List<List<Int>>) {
        Assert.assertEquals(expected, getSeparatePairs(collections))
    }
}

fun getSeparatePairs(collections: List<List<Int>>): List<Pair<List<Int>, List<Int>>> {
    return (0..(collections.size - 1)).flatMap { first ->
        ((first + 1)..collections.size - 1).map { second ->
            collections[first] to collections[second]
        }.filter { pair ->
            pair.first.all {
                !pair.second.contains(it)
            }
        }
    }
}
