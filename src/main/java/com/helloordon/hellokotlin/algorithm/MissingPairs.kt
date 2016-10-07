package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable

fun List<List<Int>>.toMissingPairs(argumentsCount: Int): Observable<List<Int>> {
    return getMissingPairs(argumentsCount, this)
}

private fun getMissingPairs(argumentsCount: Int, discernibility: List<List<Int>>): Observable<List<Int>> {
    return Observable.create({ source ->
        (0 until argumentsCount).forEach { first ->
            ((first + 1) until argumentsCount).forEach { second ->
                val pair = listOf(first, second)
                if (!discernibility.contains(pair))
                    source.onNext(pair)
            }
        }
        source.onComplete()
    })
}
