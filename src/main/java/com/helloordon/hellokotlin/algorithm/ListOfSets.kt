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

private fun initial(source: ObservableEmitter<List<Int>>): (Int, List<Int>) -> Unit {
    return { a, list ->
        source.onNext(list)
    }
}

private fun operation(n: Int): ((Int, List<Int>) -> Unit, Int) -> (Int, List<Int>) -> Unit = { action, i ->
    forFun(n - i).invoke(action)
}

private fun forFun(to: Int): ((Int, List<Int>) -> Unit) -> (Int, List<Int>) -> Unit {
    return { action ->
        { from, list ->
            (from until to).forEach {
                action(it + 1, list + it)
            }
        }
    }
}

private fun ((Int, List<Int>) -> Unit).get(): Unit {
    return this.invoke(0, emptyList())
}