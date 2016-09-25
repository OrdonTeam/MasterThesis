package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.Assert
import org.junit.Test

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
