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

private fun BooleanFunction.save(writer: OutputStreamWriter) {
    writer.use {
        writer.appendln(".type fr")
        writer.appendln(".i ${data.first().arguments.size}")
        writer.appendln(".o ${data.first().decision.length}")
        writer.appendln(".p ${data.size}")
        data.forEach {
            writer.appendln("${it.arguments.map { if (it) 1 else 0 }.joinToString("")} ${it.decision}")
        }
        writer.appendln(".e")
    }
}
