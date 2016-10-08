package com.helloordon.hellokotlin.read

import java.io.File

fun readFunction(file: File): Map<String, List<List<Boolean>>> {
    return file.readLines().map(::parseLine).groupBy({ it.first }, { it.second })
}

private fun parseLine(it: String): Pair<String, List<Boolean>> {
    val split = it.split(" ")
    return split.last() to split.dropLast(1).map { Integer.parseInt(it) != 0 }
}