package com.helloordon.hellokotlin.algorithm

fun getMissingEights(discernibility: List<List<Int>>, separateEights: List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>): List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return separateEights.filterNot {
        discernibility.contains((it.first.first + it.first.second + it.second.first + it.second.second).sorted())
    }
}