package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.*
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.writeDecomposition
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
            val function = readFunction(File(args[0])).asMap()
            val argumentsCount = function.values.first().first().size
            val discernibility = findMatrixDiscernibility(function.values.toList())

            allPairs(argumentsCount)
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .findDisjointDecompositions()
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .findDisjointDecompositions()
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .take(1)
                    .subscribe()

            allTriplets(argumentsCount)
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .findDisjointDecompositions()
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .findDisjointDecompositions()
                    .findMissingDecompositions(discernibility)
                    .writeDecomposition(writer, argumentsCount)
                    .take(1)
                    .subscribe()
        }
    }
}
