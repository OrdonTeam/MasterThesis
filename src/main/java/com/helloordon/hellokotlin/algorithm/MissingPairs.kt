package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable

fun getMissingPairs(argumentsCount: Int, pairs: List<List<Int>>): Observable<List<Int>> {
    return Observable.create({ source ->
        (0 until argumentsCount).forEach { first ->
            ((first + 1) until argumentsCount).forEach { second ->
                val pair = listOf(first, second)
                if (!pairs.contains(pair))
                    source.onNext(pair)
            }
        }
        source.onComplete()
    })
}
