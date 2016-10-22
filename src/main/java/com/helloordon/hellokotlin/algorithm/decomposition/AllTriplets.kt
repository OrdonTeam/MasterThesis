package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable

fun allTriplets(argumentsCount: Int): Observable<Argument> {
    return Observable.create({ source ->
        (0 until argumentsCount).forEach { first ->
            ((first + 1) until argumentsCount).forEach { second ->
                ((second + 1) until argumentsCount).forEach { third ->
                    source.onNext(Argument.Triplet(Argument.Single(first), Argument.Single(second), Argument.Single(third)))
                }
            }
        }
        source.onComplete()
    })
}