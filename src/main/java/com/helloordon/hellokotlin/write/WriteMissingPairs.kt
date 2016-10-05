package com.helloordon.hellokotlin.write

import java.io.OutputStream

fun writeMissingPairs(outputStream: OutputStream, argumentsCount: Int, pairs: List<List<Int>>) {
    outputStream.writer().use {
        pairs.map { pair ->
            val otherArguments = (0..(argumentsCount - 1)).filterNot { it == pair[0] || it == pair[1] }.map { " + x$it" }.joinToString("")
            "x${pair[0]} * x${pair[1]}" + otherArguments
        }.forEach { line ->
            it.appendln(line)
        }
    }
}
