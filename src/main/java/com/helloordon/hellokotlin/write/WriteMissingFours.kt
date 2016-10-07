package com.helloordon.hellokotlin.write

import java.io.OutputStreamWriter

fun writeMissingFours(writer: OutputStreamWriter, argumentsCount: Int, four: Pair<List<Int>, List<Int>>) {
    writer.appendln(four.formatFour() + four.notIncludedArguments(argumentsCount).formatArguments())
}

private fun Pair<List<Int>, List<Int>>.notIncludedArguments(argumentsCount: Int): List<Int> {
    return (0..(argumentsCount - 1)).filterNot { (first + second).contains(it) }
}

fun Pair<List<Int>, List<Int>>.formatFour(): String {
    return "(${first.formatPair()}) * (${second.formatPair()})"
}