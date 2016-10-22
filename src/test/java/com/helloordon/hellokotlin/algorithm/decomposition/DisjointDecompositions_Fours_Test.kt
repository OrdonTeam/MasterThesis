package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import com.helloordon.hellokotlin.dto.pair
import io.reactivex.Observable
import org.junit.Test

class DisjointDecompositions_Fours_Test {

    @Test
    fun shouldFindNoSeparateFours() {
        verify(
                emptyList(),
                listOf(pair(pair(0, 1), pair(2, 3))))
    }

    @Test
    fun shouldFindOnePairOfFours() {
        val one = pair(pair(0, 1), pair(2, 3))
        val two = pair(pair(4, 5), pair(6, 7))
        verify(
                listOf(pair(one, two)),
                listOf(one, two))
    }

    @Test
    fun shouldNotFindOnePairOfFours() {
        val one = pair(pair(0, 1), pair(2, 3))
        val two = pair(pair(4, 5), pair(2, 7))
        verify(
                emptyList(),
                listOf(one, two))
    }

    private fun verify(expected: List<Argument>, collections: List<Argument>) {
        Observable.fromIterable(collections)
                .findDisjointDecompositions()
                .test()
                .assertValueSequence(expected)
    }
}
