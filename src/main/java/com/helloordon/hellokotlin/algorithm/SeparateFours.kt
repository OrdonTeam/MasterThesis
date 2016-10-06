package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.allPairs

fun getSeparateFours(collections: List<Pair<List<Int>, List<Int>>>): List<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return collections.allPairs()
}