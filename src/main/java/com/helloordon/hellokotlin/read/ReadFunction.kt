package com.helloordon.hellokotlin.read

import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.dto.BooleanFunctionRow
import java.io.File

fun readFunction(file: File): BooleanFunction {
    val argumentCount = getArgumentCount(file)
    return parseFunction(argumentCount, file)
}

private fun getArgumentCount(file: File): Int {
    return file.reader().useLines {
        it.first { it.startsWith(".i") }.drop(3).trim().toInt()
    }
}

private fun parseFunction(argumentCount: Int, file: File): BooleanFunction {
    return file.reader().useLines {
        BooleanFunction(it.filterNot { it.startsWith(".") }
                .map { parseLine(it, argumentCount) }
                .toList())
    }
}

private fun parseLine(line: String, argumentCount: Int): BooleanFunctionRow {
    val noSpaces = line.replace(" ", "")
    return BooleanFunctionRow(
            noSpaces.take(argumentCount).toCharArray().map { it == '1' },
            noSpaces.drop(argumentCount))
}