package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.utils.fileFromResources
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

class WriteFunctionTest {

    val input = fileFromResources("sas1of12.pla")
    val output = File(UUID.randomUUID().toString())

    @Test
    fun shouldWriteFunctionToFile() {
        readFunction(input).save(output.writer())
        Assert.assertEquals(input.readLines().map(String::trim), output.readLines())
    }

    @After
    fun tearDown() {
        output.delete()
    }
}
