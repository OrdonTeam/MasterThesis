package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.allPairs
import com.helloordon.hellokotlin.algorithm.findDisjointDecompositions
import com.helloordon.hellokotlin.algorithm.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.findMissingDecompositions
import com.helloordon.hellokotlin.dto.pair
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import com.helloordon.hellokotlin.write.writeDecomposition
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class ExampleFunctionTest {

    val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldFindMissingPairsInCpqInFunctionFromFile() {
        val function = readFunction(fileFromResources("example_function.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        Assert.assertEquals(
                listOf(pair(0, 4), pair(2, 3), pair(2, 4)),
                allPairs(argumentsCount).findMissingDecompositions(discernibility).toList().blockingGet())
    }

    @Test
    fun shouldPairPairsNotFoundInCpqFromFile() {
        val function = readFunction(fileFromResources("example_function.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        Assert.assertEquals(
                pair(pair(0, 4), pair(2, 3)),
                allPairs(argumentsCount)
                        .findMissingDecompositions(discernibility)
                        .findDisjointDecompositions().firstOrError().blockingGet())
    }

    @Test
    fun shouldSaveMissingPairsToFile() {
        val function = readFunction(fileFromResources("example_function.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        file.writer().use { writer ->
            allPairs(argumentsCount)
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .subscribe()
        }
        Assert.assertEquals(
                listOf(
                        "x0 * x4 + x1 + x2 + x3",
                        "x2 * x3 + x0 + x1 + x4",
                        "x2 * x4 + x0 + x1 + x3"),
                file.readLines())
    }

    @Test
    fun shouldFindMissingFours() {
        val function = readFunction(fileFromResources("example_function.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        Assert.assertEquals(
                pair(pair(0, 4), pair(2, 3)),
                allPairs(argumentsCount)
                        .findMissingDecompositions(discernibility)
                        .findDisjointDecompositions()
                        .findMissingDecompositions(discernibility).firstOrError().blockingGet())
    }

    @Test
    fun shouldSaveMissingFoursToFile() {
        val function = readFunction(fileFromResources("example_function.pla"))
        val argumentsCount = function.values.first().first().size
        val discernibility = findMatrixDiscernibility(function.values.toList())
        file.writer().use { writer ->
            allPairs(argumentsCount)
                    .findMissingDecompositions(discernibility)
                    .findDisjointDecompositions().findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .subscribe()
        }
        Assert.assertEquals(
                listOf("(x0 * x4) * (x2 * x3) + x1"),
                file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
