package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import com.helloordon.hellokotlin.dto.pair
import io.reactivex.Observable
import org.junit.Test

class MissingDecompositions_Fours_Test {

    @Test
    fun shouldFindNoMissingFours() {
        verifyFoundMissingFours(
                emptyList(),
                emptyList(),
                emptyList())
    }

    @Test
    fun shouldFindMissingFour() {
        verifyFoundMissingFours(
                listOf(pair(pair(0, 4), pair(2, 3))),
                listOf(pair(pair(0, 4), pair(2, 3))),
                emptyList())
    }

    @Test
    fun shouldFilterOurFour() {
        verifyFoundMissingFours(
                emptyList(),
                listOf(pair(pair(0, 4), pair(2, 3))),
                listOf(listOf(0, 2, 3, 4)))
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
