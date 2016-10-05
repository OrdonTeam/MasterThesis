package com.helloordon.hellokotlin.read

import java.io.File

fun readFunction(file: File): Map<Boolean, List<List<Boolean>>> {
    return file.readLines().map { it.split(" ").map { Integer.parseInt(it) != 0 } }.groupBy({ it.last() }, { it.dropLast(1) })
}