package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable

fun allPairs(argumentsCount: Int): Observable<Argument> {
    return Observable.create({ source ->
        (0 until argumentsCount).forEach { first ->
            ((first + 1) until argumentsCount).forEach { second ->
                source.onNext(Argument.Single(first) with Argument.Single(second))
            }
        }
        source.onComplete()
    })
}