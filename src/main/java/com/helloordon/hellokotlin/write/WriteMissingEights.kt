package com.helloordon.hellokotlin.write

import io.reactivex.Observable
import java.io.OutputStreamWriter


fun Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>.writeEight(writer: OutputStreamWriter, argumentsCount: Int): Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return doOnNext { writeMissingEight(writer, argumentsCount, it) }
}

fun writeMissingEight(writer: OutputStreamWriter, argumentsCount: Int, eight: Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>) {
    writer.appendln(eight.formatEight() + eight.notIncludedArguments(argumentsCount).formatArguments())
}

private fun Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>.notIncludedArguments(argumentsCount: Int): List<Int> {
    return (0..(argumentsCount - 1)).filterNot {
        (first.first + first.second + second.first + second.second).contains(it)
    }
}

private fun Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>.formatEight(): String {
    return "(${first.formatFour()}) * (${second.formatFour()})"
}
