package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.common.measureTime
import com.helloordon.hellokotlin.algorithm.decomposition.applyDecomposition
import com.helloordon.hellokotlin.algorithm.decomposition.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.decomposition.listOfSets
import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.save
import io.reactivex.Observable
import java.io.File
import java.io.OutputStreamWriter
import java.util.*

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        measureTime {
            mainInternal(args)
        }
    }

    private fun mainInternal(args: Array<String>) {
        File(args[1]).writer().use { writer ->
            var function = readFunction(File(args[0]))
            function.save(writer)
            try {
                while (true) {
                    function = singleDecomposition(function, writer).blockingFirst()
                }
            } catch(e: NoSuchElementException) {
            }
        }
    }

    private fun singleDecomposition(function: BooleanFunction, writer: OutputStreamWriter): Observable<BooleanFunction> {
        val argumentsCount = function.asMap().values.first().first().size
        val discernibility = findMatrixDiscernibility(function.asMap().values.toList())

        return listOfSets(argumentsCount)
                .filter { !discernibility.contains(it) }
                .take(1)
                .doOnNext { writer.appendln(it.toString()) }
                .doOnNext { writer.appendln() }
                .map { function.applyDecomposition(it) }
                .doOnNext { it.save(writer) }
    }
}
