package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
import org.junit.Test

class MissingEightsTest {

    @Test
    fun shouldFindNoMissingEights() {
        verifyFoundMissingFours(
                emptyList(),
                emptyList(),
                emptyList())
    }

    @Test
    fun shouldFindMissingEight() {
        val one = listOf(0, 1) to listOf(2, 3)
        val two = listOf(4, 5) to listOf(6, 7)
        val eight = one to two
        verifyFoundMissingFours(
                listOf(eight),
                listOf(eight),
                emptyList())
    }

    @Test
    fun shouldFilterOurEight() {
        val one = listOf(0, 1) to listOf(2, 3)
        val two = listOf(4, 5) to listOf(6, 7)
        val eight = one to two
        verifyFoundMissingFours(
                emptyList(),
                listOf(eight),
                listOf(listOf(0, 1, 2, 3, 4, 5, 6, 7)))
    }

    private fun verifyFoundMissingFours(expected: List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>,
                                        separatePairs: List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>,
                                        discernibility: List<List<Int>>) {
        Observable.fromIterable(separatePairs)
                .toMissingEights(discernibility)
                .test()
                .assertValueSequence(expected)
    }
}
