package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.allPairs

fun getSeparatePairs(collections: List<List<Int>>): List<Pair<List<Int>, List<Int>>> {
    return collections.allPairs().filter { pair ->
        pair.first.all {
            !pair.second.contains(it)
        }
    }
}
