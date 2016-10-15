package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

fun listOfSets(n: Int): Observable<List<Int>> {
    return Observable.create { source ->
        listOfRanges(n).forEach {
            mapToListOfSets(it, n, source).get()
        }
        source.onComplete()
    }
}

private fun listOfRanges(n: Int): List<IntRange> {
    return (1 until n).map { 0..it }
}

private fun mapToListOfSets(range: IntRange, n: Int, source: ObservableEmitter<List<Int>>): Action {
    var action: Action = Action.Consumer(source)
    for (i in range) {
        action = Action.Wrapper(n - i, action)
    }
    return action
}

private sealed class Action : (Int, List<Int>) -> Unit {

    class Consumer(val source: ObservableEmitter<List<Int>>) : Action() {
        override fun invoke(from: Int, list: List<Int>) {
            source.onNext(list)
        }
    }

    class Wrapper(val to: Int, val action: Action) : Action() {
        override fun invoke(from: Int, list: List<Int>) {
            (from until to).forEach {
                action(it + 1, list + it)
            }
        }
    }

    fun get(): Unit {
        invoke(0, emptyList())
    }
}

