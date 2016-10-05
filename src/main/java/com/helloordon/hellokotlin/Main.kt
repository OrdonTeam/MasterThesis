package com.helloordon.hellokotlin

import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val function = readFunctionFromFile(File(args[0]))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!

        val discernibility = findMatrixDiscernibility(zeroRows, oneRows)
        val missingPairs = getMissingPairs(zeroRows.first().size, discernibility)
        saveMissingPairsToFile(File(args[1]), zeroRows.first().size, missingPairs)

        val separatePairs = getSeparatePairs(missingPairs)

    }
}
