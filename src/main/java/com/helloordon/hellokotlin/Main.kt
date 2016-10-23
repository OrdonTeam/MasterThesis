package com.helloordon.hellokotlin

import com.helloordon.hellokotlin.algorithm.common.measureTime
import com.helloordon.hellokotlin.algorithm.decomposition.applyDecomposition
import com.helloordon.hellokotlin.algorithm.decomposition.findMatrixDiscernibility
import com.helloordon.hellokotlin.algorithm.decomposition.listOfSets
import com.helloordon.hellokotlin.algorithm.reduction.reduceArguments
import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.read.readFunction
import com.helloordon.hellokotlin.write.save
import io.reactivex.Observable
import java.io.File
import java.io.OutputStreamWriter

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        measureTime {
            mainInternal(args)
        }
    }

    private fun mainInternal(args: Array<String>) {
        File(args[1]).writer().use { writer ->
            readFunction(File(args[0])).let {
                it.save(writer)
                it.reduceArguments().let {
                    writer.appendln("Reducing arguments\n")
                    it.save(writer)
                    writer.appendln("Compressing arguments\n")
                    singleDecomposition(it, writer).subscribe()
                }
            }
        }
    }

    private fun singleDecomposition(function: BooleanFunction, writer: OutputStreamWriter): Observable<BooleanFunction> {
        val discernibility = function.findMatrixDiscernibility()

        return listOfSets(function.getArgumentCount())
                .filter { !discernibility.contains(it) }
                .take(1)
                .doOnNext { writer.appendln(it.toString()) }
                .doOnNext { writer.appendln() }
                .map { function.applyDecomposition(it) }
                .doOnNext { it.save(writer) }
                .flatMap { singleDecomposition(it, writer) }
    }
}
