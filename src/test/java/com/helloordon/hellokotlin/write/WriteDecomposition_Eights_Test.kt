package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.pair
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteDecomposition_Eights_Test {

    val file = File(UUID.randomUUID().toString())
    val first = pair(pair(pair(0, 1), pair(2, 3)), pair(pair(4, 5), pair(6, 7)))
    val second = pair(pair(pair(0, 1), pair(2, 3)), pair(pair(4, 5), pair(6, 8)))

    @Test
    fun shouldSaveMissingFour() {
        file.writer().use { writer ->
            writeArgument(writer, 8, first)
        }
        Assert.assertEquals(listOf("((x0 * x1) * (x2 * x3)) * ((x4 * x5) * (x6 * x7))"), file.readLines())
    }

    @Test
    fun shouldSaveMissingFours() {
        file.writer().use { writer ->
            writeArgument(writer, 9, first)
            writeArgument(writer, 9, second)
        }
        Assert.assertEquals(listOf(
                "((x0 * x1) * (x2 * x3)) * ((x4 * x5) * (x6 * x7)) + x8",
                "((x0 * x1) * (x2 * x3)) * ((x4 * x5) * (x6 * x8)) + x7"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
