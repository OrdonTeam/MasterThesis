package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.allPairs
import com.helloordon.hellokotlin.algorithm.allTriplets
import com.helloordon.hellokotlin.algorithm.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.findMissingDecompositions
import com.helloordon.hellokotlin.dto.triplet
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.Test

class Sas1Of4Test {

    @Test
    fun shouldFindNoDisjointDecomposition() {
        val function = readFunction(fileFromResources("sas1of4.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        allPairs(argumentsCount)
                .findMissingDecompositions(discernibility)
                .test()
                .assertNoValues()
    }

    @Test
    fun shouldFindNonDisjointDecomposition() {
        val function = readFunction(fileFromResources("sas1of4.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        allTriplets(argumentsCount)
                .findMissingDecompositions(discernibility)
                .test()
                .assertValue(triplet(0, 1, 2))
    }
}