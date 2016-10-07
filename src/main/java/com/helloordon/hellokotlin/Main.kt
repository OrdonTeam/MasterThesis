package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.*
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.writeEight
import com.helloordon.hellokotlin.write.writeFour
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
                    .writeFour(writer, zeroRows.first().size)
                    .toSeparateFours()
                    .toMissingEights(discernibility)
                    .writeEight(writer, zeroRows.first().size)
                    .take(1)
                    .subscribe()
        }
    }
}
