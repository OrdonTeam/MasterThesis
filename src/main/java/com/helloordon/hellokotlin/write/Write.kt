package com.helloordon.hellokotlin.write

import java.io.File

fun saveMissingPairsToFile(file: File, argumentsCount: Int, pairs: List<List<Int>>) {
    file.writer().use {
        pairs.map { pair ->
            val otherArguments = (0..(argumentsCount - 1)).filterNot { it == pair[0] || it == pair[1] }.map { " + x$it" }.joinToString("")
            "x${pair[0]} * x${pair[1]}" + otherArguments
        }.forEach { line ->
            it.appendln(line)
        }
    }
}
