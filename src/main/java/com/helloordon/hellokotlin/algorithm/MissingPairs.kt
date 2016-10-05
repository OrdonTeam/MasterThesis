package com.helloordon.hellokotlin.algorithm

fun getMissingPairs(argumentsCount: Int, pairs: List<List<Int>>): List<List<Int>> {
    val list = (0..(argumentsCount - 1)).flatMap { first ->
        ((first + 1)..(argumentsCount - 1)).map { second ->
            listOf(first, second)
        }
    }
    return list.filter {
        !pairs.contains(it)
    }
}
