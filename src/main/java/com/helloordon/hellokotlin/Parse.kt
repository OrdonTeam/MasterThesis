package com.helloordon.hellokotlin

import java.io.File

fun readFunctionFromFile(file: File): Map<Boolean, List<List<Boolean>>> {
    return file.readLines().map { it.split(" ").map { Integer.parseInt(it) != 0 } }.groupBy({ it.last() }, { it.dropLast(1) })
}