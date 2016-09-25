package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.Assert
import org.junit.Test

class ParseTest {

    @Test
    fun shouldParseSingleInputFunction() {
        Assert.assertTrue(fileFromResources("singleInputFile").exists())
    }
}