package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.write.writeMissingPairs
import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val function = readFunctionFromFile(File(args[0]))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!

        val discernibility = findMatrixDiscernibility(zeroRows, oneRows)
        val missingPairs = getMissingPairs(zeroRows.first().size, discernibility)
        writeMissingPairs(File(args[1]), zeroRows.first().size, missingPairs)

        val separatePairs = getSeparatePairs(missingPairs)

    }
}
