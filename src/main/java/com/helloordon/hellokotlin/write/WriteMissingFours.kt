package com.helloordon.hellokotlin.write

import java.io.OutputStream

fun writeMissingFours(outputStream: OutputStream, argumentsCount: Int, fours: List<Pair<List<Int>, List<Int>>>) {
    outputStream.writer().use {
        fours.map { four ->
            val otherArguments = (0..(argumentsCount - 1)).filterNot { (four.first + four.second).contains(it) }.map { " + x$it" }.joinToString("")
            parseFour(four) + otherArguments
        }.forEach { line ->
            it.appendln(line)
        }
    }
}

fun parseFour(four: Pair<List<Int>, List<Int>>): String {
    return "(${parsePair(four.first)}) * (${parsePair(four.second)})"
}