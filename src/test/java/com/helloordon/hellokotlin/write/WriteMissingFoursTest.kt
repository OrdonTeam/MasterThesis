package com.helloordon.hellokotlin.write

import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteMissingFoursTest {

    val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldSaveMissingFour() {
        writeMissingFours(file, 4, listOf(listOf(0, 1) to listOf(2, 3)))
        Assert.assertEquals(listOf("(x0 * x1) * (x2 * x3)"), file.readLines())
    }

    @Test
    fun shouldSaveMissingFours() {
        writeMissingFours(file, 5, listOf(listOf(0, 1) to listOf(2, 3), listOf(1, 2) to listOf(3, 4)))
        Assert.assertEquals(listOf("(x0 * x1) * (x2 * x3) + x4", "(x1 * x2) * (x3 * x4) + x0"), file.readLines())
    }

    private fun writeMissingFours(file: File, argumentsCount: Int, fours: List<Pair<List<Int>, List<Int>>>) {
        file.writer().use {
            fours.map { four ->
                val otherArguments = (0..(argumentsCount - 1)).filterNot { (four.first + four.second).contains(it) }.map { " + x$it" }.joinToString("")
                "(x${four.first[0]} * x${four.first[1]}) * (x${four.second[0]} * x${four.second[1]})" + otherArguments
            }.forEach { line ->
                it.appendln(line)
            }
        }
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
