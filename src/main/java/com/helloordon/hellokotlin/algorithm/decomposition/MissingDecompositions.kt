package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable

fun Observable<Argument>.findMissingDecompositions(discernibility: List<List<Int>>): Observable<Argument> {
    return filter {
        !discernibility.contains(it.asList().sorted())
    }
}