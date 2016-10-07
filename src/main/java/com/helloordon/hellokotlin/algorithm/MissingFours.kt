package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable

fun Observable<Argument>.findMissing(discernibility: List<List<Int>>): Observable<Argument> {
    return compose { getMissingFours(discernibility, it) }
}

private fun getMissingFours(discernibility: List<List<Int>>, separatePairs: Observable<Argument>): Observable<Argument> {
    return separatePairs.filter {
        !discernibility.contains(it.asList().sorted())
    }
}