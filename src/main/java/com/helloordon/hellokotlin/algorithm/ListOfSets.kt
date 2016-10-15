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
    range.fold(
            Consumer(source) as Action,
            { action, i -> Wrapper(n - i, action) }
    ).get()
}

private fun ((Int, List<Int>) -> Unit).get(): Unit {
    return this.invoke(0, emptyList())
}

private interface Action : (Int, List<Int>) -> Unit

private class Consumer(val source: ObservableEmitter<List<Int>>) : Action {
    override fun invoke(from: Int, list: List<Int>) {
        source.onNext(list)
    }
}

private class Wrapper(val to: Int, val action: Action) : Action {
    override fun invoke(from: Int, list: List<Int>) {
        (from until to).forEach {
            action(it + 1, list + it)
        }
    }
}
