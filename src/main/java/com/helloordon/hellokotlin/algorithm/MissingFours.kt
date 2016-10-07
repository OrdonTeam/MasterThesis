package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable

fun getMissingFours(discernibility: List<List<Int>>, separatePairs: Observable<Pair<List<Int>, List<Int>>>): Observable<Pair<List<Int>, List<Int>>> {
    return separatePairs.filter {
        !discernibility.contains((it.first + it.second).sorted())
    }
}