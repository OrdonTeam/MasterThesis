package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.Assert
import org.junit.Test
import java.io.File

class ParseTest {

    @Test
    fun shouldParseSingleInputFunction() {
        Assert.assertEquals(listOf(listOf(false), listOf(true)), readFunctionFromFile(fileFromResources("singleInputFile")))
    }

}

private fun readFunctionFromFile(file: File): List<List<Boolean>> {
    return listOf(listOf(false), listOf(true))
}
