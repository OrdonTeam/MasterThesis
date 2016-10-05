package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.allPairs

fun getMissingPairs(argumentsCount: Int, pairs: List<List<Int>>): List<List<Int>> {
    val list = (0 until argumentsCount).allPairs().map { listOf(it.first, it.second) }
    return list.filterNot {
        pairs.contains(it)
    }
}
