package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.Argument
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteMissingPairsTest {

    private val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldSaveMissingPair() {
        file.writer().use {
            writeArgument(it, 3, Argument.Single(0) with Argument.Single(1))
        }
        Assert.assertEquals(listOf("x0 * x1 + x2"), file.readLines())
    }

    @Test
    fun shouldSaveMissingPairs() {
        file.writer().use {
            writeArgument(it, 3, Argument.Single(0) with Argument.Single(1))
            writeArgument(it, 3, Argument.Single(0) with Argument.Single(2))
        }
        Assert.assertEquals(listOf("x0 * x1 + x2", "x0 * x2 + x1"), file.readLines())
    }

    @Test
    fun shouldSaveMissingPairFor4Arguments() {
        file.writer().use {
            writeArgument(it, 4, Argument.Single(0) with Argument.Single(1))
        }
        Assert.assertEquals(listOf("x0 * x1 + x2 + x3"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
