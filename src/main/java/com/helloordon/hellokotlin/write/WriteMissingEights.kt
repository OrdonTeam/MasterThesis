package com.helloordon.hellokotlin.write

import java.io.OutputStream

fun writeMissingEights(outputStream: OutputStream, argumentsCount: Int, eights: List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>) {
    outputStream.writer().use {
        eights.map { eight ->
            val otherArguments = notIncludedArguments(argumentsCount, eight).map { " + x$it" }.joinToString("")
            parseEight(eight) + otherArguments
        }.forEach { line ->
            it.appendln(line)
        }
    }
}

private fun notIncludedArguments(argumentsCount: Int, eight: Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>): List<Int> {
    return (0..(argumentsCount - 1)).filterNot {
        (eight.first.first + eight.first.second + eight.second.first + eight.second.second).contains(it)
    }
}

private fun parseEight(eight: Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>): String {
    return "(${parseFour(eight.first)}) * (${parseFour(eight.second)})"
}
