package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.*
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.*
import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println(System.currentTimeMillis())
        try {
            mainInternal(args)
        } finally {
            println(System.currentTimeMillis())
        }
    }

    private fun mainInternal(args: Array<String>) {
        File(args[1]).clear()
        val function = readFunction(File(args[0]))
        val zeroRows = function[false]!!
        val oneRows = function[true]!!

        val discernibility = findMatrixDiscernibility(zeroRows, oneRows)
        val missingPairs = getMissingPairs(zeroRows.first().size, discernibility)
        writeMissingPairs(File(args[1]).appendingOutputStream(), zeroRows.first().size, missingPairs.toList().blockingGet())

        val separatePairs = missingPairs.toSeparatePairs()
        val missingFours =  separatePairs.toMissingFours(discernibility)
        writeMissingFours(File(args[1]).appendingOutputStream(), zeroRows.first().size, missingFours.toList().blockingGet())

        val separateFours = missingFours.toSeparateFours()
        val missingEights = separateFours.toMissingEights(discernibility)
        writeMissingEights(File(args[1]).appendingOutputStream(), zeroRows.first().size, missingEights.toList().blockingGet())
    }
}
