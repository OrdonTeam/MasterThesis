package com.helloordon.hellokotlin.read

import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.Assert
import org.junit.Test

class ReadFunctionTest {

    @Test
    fun shouldParseSingleInputFunction() {
        Assert.assertEquals(
                mapOf(
                        "0" to listOf(listOf(false)),
                        "1" to listOf(listOf(true))),
                readFunction(fileFromResources("singleInputFile")).asMap())
    }

    @Test
    fun shouldParseTwoInputFunction() {
        Assert.assertEquals(
                mapOf(
                        "0" to listOf(listOf(false, false), listOf(false, true)),
                        "1" to listOf(listOf(true, false))),
                readFunction(fileFromResources("twoInputFile")).asMap())
    }
}
