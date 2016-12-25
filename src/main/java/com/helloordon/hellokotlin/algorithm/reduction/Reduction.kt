package com.helloordon.hellokotlin.algorithm.reduction

import com.helloordon.hellokotlin.algorithm.decomposition.findMatrixDiscernibility
import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.dto.BooleanFunctionRow

fun findBestArgumentToReduction(discernibility: List<List<Int>>): Int {
    val minDiscernibilityLength = discernibility.minBy { it.count() }!!.count()
    val candidates = discernibility.filter { it.count() == minDiscernibilityLength }.flatMap { it }
    val countInColumns = discernibility.flatMap { it }.groupBy { it }.mapValues { it.value.count() }
    return countInColumns.filter { candidates.contains(it.key) }.maxBy { it.value }!!.key
}

fun removeRowsFromDiscernibility(discernibility: List<List<Int>>, argument: Int): List<List<Int>> {
    return discernibility.filterNot { it.contains(argument) }
}

fun findReduct(discernibility: List<List<Int>>): List<Int> {
    if (discernibility.isEmpty()) return emptyList()
    val bestArgument = findBestArgumentToReduction(discernibility)
    return (findReduct(removeRowsFromDiscernibility(discernibility, bestArgument)) + bestArgument).sorted()
}

fun findMinimalReduct(discernibility: List<List<Int>>): List<Int> {
    return findReduct(discernibility).removeRedundantAttributes(discernibility)
}

fun BooleanFunction.reduceArguments(): BooleanFunction {
    return this.applyReduct(findMinimalReduct(findMatrixDiscernibility()))
}

fun BooleanFunction.applyReduct(reduct: List<Int>): BooleanFunction {
    return BooleanFunction(data.map {
        BooleanFunctionRow(it.arguments.filterIndexed { index, value -> reduct.contains(index) }, it.decision)
    }.distinct(), applyReductionOnArgumentNames(argumentNames, reduct))
}

fun applyReductionOnArgumentNames(argumentNames: List<String>, reduct: List<Int>): List<String> {
    return argumentNames.filterIndexed { index, s -> reduct.contains(index) }
}
