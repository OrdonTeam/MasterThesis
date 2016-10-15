package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

fun listOfSets(n: Int): Observable<List<Int>> {
    return Observable.create { source ->
        listOfRanges(n).forEach {
            mapToListOfSets(it, n, source)
        }
        source.onComplete()
    }
}

private fun listOfRanges(n: Int): List<IntRange> {
    return (1 until n).map { 0..it }
}

private fun mapToListOfSets(range: IntRange, n: Int, source: ObservableEmitter<List<Int>>) {
    range.fold(initial(source), operation(n)).get()
}

private fun initial(source: ObservableEmitter<List<Int>>): (Int, List<Int>) -> List<List<Int>> {
    return { a, list ->
        source.onNext(list)
        listOf(list)
    }
}

private fun operation(n: Int): ((Int, List<Int>) -> List<List<Int>>, Int) -> (Int, List<Int>) -> List<List<Int>> = { action, i ->
    forFun(n - i).invoke(action)
}

private fun forFun(to: Int): ((Int, List<Int>) -> List<List<Int>>) -> (Int, List<Int>) -> List<List<Int>> {
    return { action ->
        { from, list ->
            (from until to).flatMap {
                action(it + 1, list + it)
            }
        }
    }
}

private fun ((Int, List<Int>) -> List<List<Int>>).get(): List<List<Int>> {
    return this.invoke(0, emptyList())
}