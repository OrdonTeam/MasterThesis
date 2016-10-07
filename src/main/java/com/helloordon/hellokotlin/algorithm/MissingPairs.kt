package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable

fun List<List<Int>>.toMissingPairs(argumentsCount: Int): Observable<Argument> {
    return getMissingPairs(argumentsCount, this)
}

private fun getMissingPairs(argumentsCount: Int, discernibility: List<List<Int>>): Observable<Argument> {
    return Observable.create({ source ->
        (0 until argumentsCount).forEach { first ->
            ((first + 1) until argumentsCount).forEach { second ->
                val pair = Argument.Single(first) with Argument.Single(second)
                if (!discernibility.contains(pair.asList()))
                    source.onNext(pair)
            }
        }
        source.onComplete()
    })
}
