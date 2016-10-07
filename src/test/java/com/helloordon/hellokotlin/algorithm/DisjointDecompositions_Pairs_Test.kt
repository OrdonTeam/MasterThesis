package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import com.helloordon.hellokotlin.dto.pair
import io.reactivex.Observable
import org.junit.Test

class DisjointDecompositions_Pairs_Test {

    @Test
    fun shouldFindNoSeparatePairs() {
        verify(emptyList(), listOf(pair(0, 1)))
    }

    @Test
    fun shouldFindOneSeparatePair() {
        verify(listOf(pair(pair(0, 1), pair(2, 3))), listOf(pair(0, 1), pair(2, 3)))
    }

    @Test
    fun shouldNotFindNotSeparatePair() {
        verify(emptyList(), listOf(pair(0, 1), pair(1, 2)))
    }

    private fun verify(expected: List<Argument>, collections: List<Argument>) {
        Observable.fromIterable(collections)
                .findDisjointDecompositions()
                .test()
                .assertValueSequence(expected)
    }
}
