package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.dto.BooleanFunctionRow

fun BooleanFunction.applyDecomposition(decomposition: List<Int>): BooleanFunction {
    return BooleanFunction(data.map { it.applyDecomposition(decomposition) })
}

private fun BooleanFunctionRow.applyDecomposition(decomposition: List<Int>): BooleanFunctionRow {
    return copy(arguments.applyDecomposition(decomposition))
}

private fun List<Boolean>.applyDecomposition(decomposition: List<Int>): List<Boolean> {
    return argumentsNotInDecomposition(decomposition) + argumentsInDecomposition(decomposition)
}

private fun List<Boolean>.argumentsNotInDecomposition(decomposition: List<Int>) = filterIndexed { i, b -> !decomposition.contains(i) }

private fun List<Boolean>.argumentsInDecomposition(decomposition: List<Int>): List<Boolean> {
    val arguments = filterIndexed { i, b -> decomposition.contains(i) }
    return arguments.dropLast(1).zip(arguments.drop(1)).map { it.first.xor(it.second) }
}