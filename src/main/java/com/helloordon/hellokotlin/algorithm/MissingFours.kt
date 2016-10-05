package com.helloordon.hellokotlin.algorithm

fun getMissingFours(discernibility: List<List<Int>>, separatePairs: List<Pair<List<Int>, List<Int>>>): List<Pair<List<Int>, List<Int>>> {
    return separatePairs.filterNot {
        discernibility.contains((it.first + it.second).sorted())
    }
}