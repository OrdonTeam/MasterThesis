package com.helloordon.hellokotlin.algorithm.reduction

fun List<Int>.removeRedundantAttributes(discernibility: List<List<Int>>): List<Int> {
    return if (isSufficient(this.drop(1), discernibility)) this else this.drop(1)
}

fun isSufficient(reduct: List<Int>, discernibility: List<List<Int>>): Boolean {
    return !discernibility.all { row ->
        reduct.any { index ->
            row.contains(index)
        }
    }
}
