package com.helloordon.hellokotlin

import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val function = readFunctionFromFile(File(args[0]))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!
        saveMissingPairsToFile(File(args[1]), zeroRows.first().size,
                getMissingPairs(
                        zeroRows.first().size,
                        findMatrixDiscernibility(zeroRows, oneRows)))
    }
}
