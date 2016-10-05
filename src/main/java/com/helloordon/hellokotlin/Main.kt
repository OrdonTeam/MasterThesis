package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.write.appendingOutputStream
import com.helloordon.hellokotlin.write.clear
import com.helloordon.hellokotlin.write.writeMissingFours
import com.helloordon.hellokotlin.write.writeMissingPairs
import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        File(args[1]).clear()
        val function = readFunctionFromFile(File(args[0]))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!

        val discernibility = findMatrixDiscernibility(zeroRows, oneRows)
        val missingPairs = getMissingPairs(zeroRows.first().size, discernibility)
        writeMissingPairs(File(args[1]).appendingOutputStream(), zeroRows.first().size, missingPairs)

        val separatePairs = getSeparatePairs(missingPairs)
        val missingFours = getMissingFours(discernibility, separatePairs)
        writeMissingFours(File(args[1]).appendingOutputStream(), zeroRows.first().size, missingFours)
    }
}
