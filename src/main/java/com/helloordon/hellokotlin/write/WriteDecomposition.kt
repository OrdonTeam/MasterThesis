package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable
import java.io.OutputStreamWriter

fun Observable<Argument>.writeDecomposition(writer: OutputStreamWriter, argumentsCount: Int): Observable<Argument> {
    return doOnNext { writeArgument(writer, argumentsCount, it) }
}

private fun writeArgument(writer: OutputStreamWriter, argumentsCount: Int, pair: Argument) {
    writer.appendln(pair.format() + pair.notIncludedArguments(argumentsCount).formatArguments())
}

private fun Argument.notIncludedArguments(argumentsCount: Int): List<Int> {
    return (0..(argumentsCount - 1)).filterNot { asList().contains(it) }
}

private fun List<Int>.formatArguments(): String {
    return map { " + x$it" }.joinToString("")
}

private fun Argument.format(): String {
    return when (this) {
        is Argument.Single -> "x$x"
        is Argument.Pair -> when (first) {
            is Argument.Single -> "${first.format()} * ${second.format()}"
            is Argument.Pair -> "(${first.format()}) * (${second.format()})"
        }
    }
}
