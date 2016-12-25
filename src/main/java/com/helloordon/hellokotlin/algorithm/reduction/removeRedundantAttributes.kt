package com.helloordon.hellokotlin.algorithm.reduction

fun List<Int>.removeRedundantAttributes(discernibility: List<List<Int>>): List<Int> {
    return discernibility.removeRedundant(emptyList(), this)
}

private fun List<List<Int>>.removeRedundant(checked: List<Int>, unchecked: List<Int>): List<Int> {
    if (unchecked.isEmpty()) {
        return checked
    } else if (isSufficient(checked + unchecked.drop(1))) {
        return removeRedundant(checked + unchecked.first(), unchecked.drop(1))
    } else {
        return removeRedundant(checked, unchecked.drop(1))
    }
}

fun List<List<Int>>.isSufficient(reduct: List<Int>): Boolean {
    return !all { row ->
        reduct.any { index ->
            row.contains(index)
        }
    }
}
