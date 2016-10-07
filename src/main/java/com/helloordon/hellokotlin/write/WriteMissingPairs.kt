package com.helloordon.hellokotlin.write

import io.reactivex.Observable
import java.io.OutputStreamWriter

fun Observable<List<Int>>.writePair(writer: OutputStreamWriter, argumentsCount: Int): Observable<List<Int>> {
    return doOnNext { writeMissingPair(writer, argumentsCount, it) }
}

fun writeMissingPair(writer: OutputStreamWriter, argumentsCount: Int, pair: List<Int>) {
    writer.appendln(pair.formatPair() + pair.notIncludedArguments(argumentsCount).formatArguments())
}

private fun List<Int>.notIncludedArguments(argumentsCount: Int): List<Int> {
    return (0..(argumentsCount - 1)).filterNot { it == this[0] || it == this[1] }
}

fun List<Int>.formatArguments(): String {
    return map { " + x$it" }.joinToString("")
}

fun List<Int>.formatPair(): String {
    return "x${this[0]} * x${this[1]}"
}
