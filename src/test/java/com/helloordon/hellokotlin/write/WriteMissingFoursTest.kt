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
        file.writer().use {
            writeMissingFour(it, 4, listOf(0, 1) to listOf(2, 3))
        }
        Assert.assertEquals(listOf("(x0 * x1) * (x2 * x3)"), file.readLines())
    }

    @Test
    fun shouldSaveMissingFours() {
        file.writer().use {
            writeMissingFour(it, 5, listOf(0, 1) to listOf(2, 3))
            writeMissingFour(it, 5, listOf(1, 2) to listOf(3, 4))
        }
        Assert.assertEquals(listOf("(x0 * x1) * (x2 * x3) + x4", "(x1 * x2) * (x3 * x4) + x0"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
