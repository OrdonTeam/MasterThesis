package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import com.helloordon.hellokotlin.dto.pair
import io.reactivex.Observable
import org.junit.Test

class MissingDecompositions_Eights_Test {

    @Test
    fun shouldFindNoMissingEights() {
        verifyFoundMissingFours(
                emptyList(),
                emptyList(),
                emptyList())
    }

    @Test
    fun shouldFindMissingEight() {
        val one = pair(pair(0, 1), pair(2, 3))
        val two = pair(pair(4, 5), pair(6, 7))
        val eight = pair(one, two)
        verifyFoundMissingFours(
                listOf(eight),
                listOf(eight),
                emptyList())
    }

    @Test
    fun shouldFilterOurEight() {
        val one = pair(pair(0, 1), pair(2, 3))
        val two = pair(pair(4, 5), pair(6, 7))
        val eight = pair(one, two)
        verifyFoundMissingFours(
                emptyList(),
                listOf(eight),
                listOf(listOf(0, 1, 2, 3, 4, 5, 6, 7)))
    }

    private fun verifyFoundMissingFours(expected: List<Argument>,
                                        separatePairs: List<Argument>,
                                        discernibility: List<List<Int>>) {
        Observable.fromIterable(separatePairs)
                .findMissingDecompositions(discernibility)
                .test()
                .assertValueSequence(expected)
    }
}
