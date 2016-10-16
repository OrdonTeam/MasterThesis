package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteFunctionTest {

    val input = fileFromResources("sas1of12.pla")
    val output = File(UUID.randomUUID().toString())

    @Test
    fun shouldWriteFunctionToFile() {
        output.writer().use {
            readFunction(input).save(it)
        }
        Assert.assertEquals(input.readLines().map(String::trim), output.readLines())
    }

    @After
    fun tearDown() {
        output.delete()
    }
}
