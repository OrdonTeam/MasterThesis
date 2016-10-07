package com.helloordon.hellokotlin.write

import io.reactivex.Observable
import java.io.OutputStreamWriter

fun Observable<Pair<List<Int>, List<Int>>>.writeFour(writer: OutputStreamWriter, argumentsCount: Int): Observable<Pair<List<Int>, List<Int>>> {
    return doOnNext { writeMissingFour(writer, argumentsCount, it) }
}

fun writeMissingFour(writer: OutputStreamWriter, argumentsCount: Int, four: Pair<List<Int>, List<Int>>) {
    writer.appendln(four.formatFour() + four.notIncludedArguments(argumentsCount).formatArguments())
}

private fun Pair<List<Int>, List<Int>>.notIncludedArguments(argumentsCount: Int): List<Int> {
    return (0..(argumentsCount - 1)).filterNot { (first + second).contains(it) }
}

fun Pair<List<Int>, List<Int>>.formatFour(): String {
    return "(${first.formatPair()}) * (${second.formatPair()})"
}