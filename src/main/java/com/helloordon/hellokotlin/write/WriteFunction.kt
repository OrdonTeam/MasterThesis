package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.BooleanFunction
import java.io.OutputStreamWriter

fun BooleanFunction.save(writer: OutputStreamWriter) {
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