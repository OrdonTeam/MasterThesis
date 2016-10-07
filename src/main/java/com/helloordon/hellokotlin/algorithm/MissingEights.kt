package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable

fun Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>.toMissingEights(discernibility: List<List<Int>>): Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return compose { getMissingEights(discernibility, it) }
}

private fun getMissingEights(discernibility: List<List<Int>>, separateFours: Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>): Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return separateFours.filter {
        !discernibility.contains((it.first.first + it.first.second + it.second.first + it.second.second).sorted())
    }
}