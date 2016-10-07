package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.getMissingPairs
import com.helloordon.hellokotlin.algorithm.toMissingFours
import com.helloordon.hellokotlin.algorithm.toSeparatePairs
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import com.helloordon.hellokotlin.write.writeFour
import com.helloordon.hellokotlin.write.writePair
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class ExampleFunctionTest {

    val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldCalculateCpq() {
        val zeroRows = listOf(
                listOf(0, 0, 0, 0, 0),
                listOf(0, 0, 1, 1, 1),
                listOf(0, 1, 0, 1, 0),
                listOf(0, 1, 1, 1, 1),
                listOf(0, 1, 1, 0, 0)).toBoolean()
        val oneRows = listOf(
                listOf(0, 0, 0, 1, 1),
                listOf(0, 1, 0, 0, 0),
                listOf(0, 1, 1, 0, 1),
                listOf(1, 1, 0, 1, 0),
                listOf(1, 0, 0, 1, 1),
                listOf(1, 0, 0, 1, 0)).toBoolean()
        Assert.assertTrue(
                findMatrixDiscernibility(zeroRows, oneRows).filter { it.size == 2 }.containsAll(
                        listOf(listOf(3, 4), listOf(0, 3), listOf(1, 3), listOf(0, 2), listOf(1, 4), listOf(0, 1), listOf(1, 2))
                ))
    }

    @Test
    fun shouldFindMissingPairsInCpq() {
        val zeroRows = listOf(
                listOf(0, 0, 0, 0, 0),
                listOf(0, 0, 1, 1, 1),
                listOf(0, 1, 0, 1, 0),
                listOf(0, 1, 1, 1, 1),
                listOf(0, 1, 1, 0, 0)).toBoolean()
        val oneRows = listOf(
                listOf(0, 0, 0, 1, 1),
                listOf(0, 1, 0, 0, 0),
                listOf(0, 1, 1, 0, 1),
                listOf(1, 1, 0, 1, 0),
                listOf(1, 0, 0, 1, 1),
                listOf(1, 0, 0, 1, 0)).toBoolean()
        Assert.assertEquals(listOf(listOf(0, 4), listOf(2, 3), listOf(2, 4)), getMissingPairs(5, findMatrixDiscernibility(zeroRows, oneRows)).toList().blockingGet())
    }

    @Test
    fun shouldFindMissingPairsInCpqInFunctionFromFile() {
        val function = readFunction(fileFromResources("example_function"))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!
        Assert.assertEquals(
                listOf(listOf(0, 4), listOf(2, 3), listOf(2, 4)),
                getMissingPairs(
                        zeroRows.first().size,
                        findMatrixDiscernibility(zeroRows, oneRows)).toList().blockingGet())
    }

    @Test
    fun shouldPairPairsNotFoundInCpqFromFile() {
        val function = readFunction(fileFromResources("example_function"))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!
        Assert.assertEquals(
                listOf(listOf(0, 4) to listOf(2, 3)),
                getMissingPairs(
                        zeroRows.first().size,
                        findMatrixDiscernibility(zeroRows, oneRows)).toSeparatePairs().toList().blockingGet())
    }

    @Test
    fun shouldSaveMissingPairsToFile() {
        val function = readFunction(fileFromResources("example_function"))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!
        file.writer().use { writer ->
            getMissingPairs(
                    zeroRows.first().size,
                    findMatrixDiscernibility(zeroRows, oneRows))
                    .writePair(writer, zeroRows.first().size)
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
        val function = readFunction(fileFromResources("example_function"))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!
        val discernibility = findMatrixDiscernibility(zeroRows, oneRows)
        Assert.assertEquals(
                listOf(listOf(0, 4) to listOf(2, 3)),
                getMissingPairs(
                        zeroRows.first().size,
                        discernibility)
                        .toSeparatePairs()
                        .toMissingFours(discernibility).toList().blockingGet())
    }

    @Test
    fun shouldSaveMissingFoursToFile() {
        val function = readFunction(fileFromResources("example_function"))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!
        val discernibility = findMatrixDiscernibility(zeroRows, oneRows)
        file.writer().use { writer ->
            getMissingPairs(
                    zeroRows.first().size,
                    discernibility).toSeparatePairs().toMissingFours(discernibility)
                    .writeFour(writer, zeroRows.first().size)
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

    private fun List<List<Int>>.toBoolean() = map { it.map { if (it == 0) false else true } }
}

