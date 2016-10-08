package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.allPairs
import com.helloordon.hellokotlin.algorithm.allTriplets
import com.helloordon.hellokotlin.algorithm.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.findMissingDecompositions
import com.helloordon.hellokotlin.dto.triplet
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import com.helloordon.hellokotlin.write.writeDecomposition
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class Sas1Of4Test {

    val file = File(UUID.randomUUID().toString())

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
        file.writer().use { writer ->
            allTriplets(argumentsCount)
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .test()
                    .assertValue(triplet(0, 1, 2))
        }
        Assert.assertEquals(
                listOf("(x0 * x1) + (x1 * x2)"),
                file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}