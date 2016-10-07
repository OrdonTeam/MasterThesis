package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.*
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.writeMissingEights
import com.helloordon.hellokotlin.write.writeMissingFours
import com.helloordon.hellokotlin.write.writeMissingPair
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
        File(args[1]).writer().use { writer ->
            val function = readFunction(File(args[0]))
            val zeroRows = function[false]!!
            val oneRows = function[true]!!
            val discernibility = findMatrixDiscernibility(zeroRows, oneRows)

            getMissingPairs(zeroRows.first().size, discernibility)
                    .doOnNext { writeMissingPair(writer, zeroRows.first().size, it) }
                    .toSeparatePairs()
                    .toMissingFours(discernibility)
                    .doOnNext { writeMissingFours(writer, zeroRows.first().size, it) }
                    .toSeparateFours()
                    .toMissingEights(discernibility)
                    .doOnNext { writeMissingEights(writer, zeroRows.first().size, it) }
                    .take(1)
                    .subscribe()
        }
    }
}
