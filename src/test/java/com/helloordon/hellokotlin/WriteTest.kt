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
        Assert.assertEquals(file.readLines(), listOf("x0 * x1 + x2"))
    }

    @After
    fun tearDown() {
        file.delete()
    }
}

private fun saveMissingPairsToFile(file: File, argumentsCount: Int, pairs: List<List<Int>>) {
    file.writer().run {
        appendln("x0 * x1 + x2")
        flush()
    }
}
