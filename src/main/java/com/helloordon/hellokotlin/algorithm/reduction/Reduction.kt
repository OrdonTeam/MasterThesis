package com.helloordon.hellokotlin.algorithm.reduction

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
