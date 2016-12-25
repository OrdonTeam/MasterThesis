package com.helloordon.hellokotlin.algorithm.reduction

fun List<Int>.removeRedundantAttributes(discernibility: List<List<Int>>): List<Int> {
    if (this.isEmpty()) {
        return this
    } else if (isSufficient(this.drop(1), discernibility)) {
        return this
    } else {
        return this.drop(1).removeRedundantAttributes(discernibility)
    }
}

fun isSufficient(reduct: List<Int>, discernibility: List<List<Int>>): Boolean {
    return !discernibility.all { row ->
        reduct.any { index ->
            row.contains(index)
        }
    }
}
