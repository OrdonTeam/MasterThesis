package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.decomposition.allTriplets
import com.helloordon.hellokotlin.algorithm.decomposition.findDisjointDecompositions
import com.helloordon.hellokotlin.algorithm.decomposition.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.decomposition.findMissingDecompositions
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import com.helloordon.hellokotlin.write.writeDecomposition
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class Sas1Of7Test {

    val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldFindNonDisjointDecomposition() {
        val function = readFunction(fileFromResources("sas1of7.pla"))
        val argumentsCount = function.asMap().values.first().first().size
        val discernibility = findMatrixDiscernibility(function.asMap().values.toList())
        file.writer().use { writer ->
            allTriplets(argumentsCount)
                    .findMissingDecompositions(discernibility)
                    .findDisjointDecompositions()
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .subscribe()
        }
        Assert.assertTrue(file.readLines().contains("((x0 * x1) + (x1 * x2)) * ((x3 * x4) + (x4 * x5))"))
    }

    @After
    fun tearDown() {
        file.delete()
    }
}