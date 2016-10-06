package com.helloordon.hellokotlin.write

import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteMissingEightsTest {

    val file = File(UUID.randomUUID().toString())
    val first = (listOf(0, 1) to listOf(2, 3)) to (listOf(4, 5) to listOf(6, 7))
    val second = (listOf(0, 1) to listOf(2, 3)) to (listOf(4, 5) to listOf(6, 8))

    @Test
    fun shouldSaveMissingFour() {
        writeMissingEights(file.appendingOutputStream(), 8, listOf(first))
        Assert.assertEquals(listOf("((x0 * x1) * (x2 * x3)) * ((x4 * x5) * (x6 * x7))"), file.readLines())
    }

    @Test
    fun shouldSaveMissingFours() {
        writeMissingEights(file.appendingOutputStream(), 9, listOf(first, second))
        Assert.assertEquals(listOf(
                "((x0 * x1) * (x2 * x3)) * ((x4 * x5) * (x6 * x7)) + x8",
                "((x0 * x1) * (x2 * x3)) * ((x4 * x5) * (x6 * x8)) + x7"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
