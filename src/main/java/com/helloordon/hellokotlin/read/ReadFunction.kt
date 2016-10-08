package com.helloordon.hellokotlin.read

import java.io.File

fun readFunction(file: File): Map<String, List<List<Boolean>>> {
    val readFile = file.readLines().groupBy { it.startsWith(".") }
    val argumentCount = getArgumentCount(readFile)
    return parseFunction(argumentCount, readFile)
}

private fun parseFunction(argumentCount: Int, readFile: Map<Boolean, List<String>>) = readFile[false]!!.map { parseLine(it, argumentCount) }.groupBy({ it.first }, { it.second })

private fun getArgumentCount(readFile: Map<Boolean, List<String>>) = readFile[true]!!.first { it.startsWith(".i") }.split(" ")[1].toInt()

private fun parseLine(line: String, argumentCount: Int): Pair<String, List<Boolean>> {
    val noSpaces = line.replace(" ", "")
    return noSpaces.drop(argumentCount) to
            noSpaces.take(argumentCount).toCharArray().map { it == '1' }
}