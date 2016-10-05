package com.helloordon.hellokotlin.algorithm

fun getSeparatePairs(collections: List<List<Int>>): List<Pair<List<Int>, List<Int>>> {
    return (0..(collections.size - 1)).flatMap { first ->
        ((first + 1)..collections.size - 1).map { second ->
            collections[first] to collections[second]
        }.filter { pair ->
            pair.first.all {
                !pair.second.contains(it)
            }
        }
    }
}