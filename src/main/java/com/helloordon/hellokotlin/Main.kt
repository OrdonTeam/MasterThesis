package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.toMissingFours
import com.helloordon.hellokotlin.algorithm.toMissingPairs
import com.helloordon.hellokotlin.algorithm.toSeparatePairs
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.writePair
import java.io.File

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        val start = System.currentTimeMillis()
        println(start)
        try {
            mainInternal(args)
        } finally {
            val end = System.currentTimeMillis()
            println(end)
            println("${(end - start) / 1000.0} sec")
        }
    }

    private fun mainInternal(args: Array<String>) {
        File(args[1]).writer().use { writer ->
            val function = readFunction(File(args[0]))
            val zeroRows = function[false]!!
            val oneRows = function[true]!!
            val discernibility = findMatrixDiscernibility(zeroRows, oneRows)

            discernibility
                    .toMissingPairs(zeroRows.first().size)
                    .writePair(writer, zeroRows.first().size)
                    .toSeparatePairs()
                    .toMissingFours(discernibility)
                    .writePair(writer, zeroRows.first().size)
                    .toSeparatePairs()
                    .toMissingFours(discernibility)
                    .writePair(writer, zeroRows.first().size)
                    .take(1)
                    .subscribe()
        }
    }
}
