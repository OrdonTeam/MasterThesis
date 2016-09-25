package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.Assert
import org.junit.Test
import java.io.File

class ParseTest {

    @Test
    fun shouldParseSingleInputFunction() {
        Assert.assertEquals(
                mapOf(
                        false to listOf(listOf(false)),
                        true to listOf(listOf(true))),
                readFunctionFromFile(fileFromResources("singleInputFile")))
    }

    @Test
    fun shouldParseTwoInputFunction() {
        Assert.assertEquals(
                mapOf(
                        false to listOf(listOf(false, false), listOf(false, true)),
                        true to listOf(listOf(true, false))),
                readFunctionFromFile(fileFromResources("twoInputFile")))
    }
}

private fun readFunctionFromFile(file: File): Map<Boolean, List<List<Boolean>>> {
    return file.readLines().map { it.split(" ").map { Integer.parseInt(it) != 0 } }.groupBy({ it.last() }, { it.dropLast(1) })
}
