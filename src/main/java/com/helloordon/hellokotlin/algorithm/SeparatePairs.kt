package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.allPairs
import com.helloordon.hellokotlin.util.isDisjointWith

fun getSeparatePairs(collections: List<List<Int>>): List<Pair<List<Int>, List<Int>>> {
    return collections.allPairs().filter {
        it.first isDisjointWith it.second
    }
}
