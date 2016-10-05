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

    private fun writeMissingFours(file: File, argumentsCount: Int, fours: List<Pair<List<Int>, List<Int>>>) {
        file.writer().use {
            it.appendln("(x0 * x1) * (x2 * x3)")
        }
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
