package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class SeparatePairsTest {

    @Test
    fun shouldFindNoSeparatePairs() {
        verify(emptyList(), listOf(listOf(0, 1)))
    }

    private fun verify(expected: List<List<Int>>, collections: List<List<Int>>) {
        Assert.assertEquals(expected, getSeparatePairs(collections))
    }

}

fun getSeparatePairs(collections: List<List<Int>>): List<List<Int>> {
    return emptyList()
}
