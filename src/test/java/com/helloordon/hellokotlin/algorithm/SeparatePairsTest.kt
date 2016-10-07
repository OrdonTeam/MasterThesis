package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
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
        Observable.fromIterable(collections)
                .toSeparatePairs()
                .test()
                .assertValueSequence(expected)
    }
}
