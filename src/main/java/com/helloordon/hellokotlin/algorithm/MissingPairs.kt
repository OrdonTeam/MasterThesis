package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable

fun List<List<Int>>.toMissingPairs(argumentsCount: Int): Observable<Argument> {
    return getMissingPairs(argumentsCount, this)
}

private fun getMissingPairs(argumentsCount: Int, discernibility: List<List<Int>>): Observable<Argument> {
    return allPairs(argumentsCount).filter {
        !discernibility.contains(it.asList().sorted())
    }
}

private fun allPairs(argumentsCount: Int): Observable<Argument> {
    return Observable.create({ source ->
        (0 until argumentsCount).forEach { first ->
            ((first + 1) until argumentsCount).forEach { second ->
                source.onNext(Argument.Single(first) with Argument.Single(second))
            }
        }
        source.onComplete()
    })
}