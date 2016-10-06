package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.allPairs
import com.helloordon.hellokotlin.util.isDisjointWith

fun getSeparateFours(collections: List<Pair<List<Int>, List<Int>>>): List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return collections.allPairs().filter {
        (it.first.first + it.first.second) isDisjointWith (it.second.first + it.second.second)
    }
}