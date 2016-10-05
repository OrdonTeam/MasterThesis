package com.helloordon.hellokotlin.write

import java.io.OutputStream

fun writeMissingFours(outputStream: OutputStream, argumentsCount: Int, fours: List<Pair<List<Int>, List<Int>>>) {
    outputStream.writer().use {
        fours.map { four ->
            val otherArguments = (0..(argumentsCount - 1)).filterNot { (four.first + four.second).contains(it) }.map { " + x$it" }.joinToString("")
            "(x${four.first[0]} * x${four.first[1]}) * (x${four.second[0]} * x${four.second[1]})" + otherArguments
        }.forEach { line ->
            it.appendln(line)
        }
    }
}