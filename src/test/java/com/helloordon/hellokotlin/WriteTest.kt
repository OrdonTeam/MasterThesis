package com.helloordon.hellokotlin

import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteTest {

    val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldSaveMissingPair() {
        saveMissingPairsToFile(file, 3, listOf(listOf(0, 1)))
        Assert.assertEquals(listOf("x0 * x1 + x2"), file.readLines())
    }

    @Test
    fun shouldSaveMissingPairs() {
        saveMissingPairsToFile(file, 3, listOf(listOf(0, 1), listOf(0, 2)))
        Assert.assertEquals(listOf("x0 * x1 + x2", "x0 * x2 + x1"), file.readLines())
    }

    @Test
    fun shouldSaveMissingPairFor4Arguments() {
        saveMissingPairsToFile(file, 4, listOf(listOf(0, 1)))
        Assert.assertEquals(listOf("x0 * x1 + x2 + x3"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
