package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

fun listOfSets(n: Int): Observable<List<Int>> {
    return Observable.create { source ->
        (2..n).forEach {
            mapToListOfSets(it, n, source).get()
        }
        source.onComplete()
    }
}

private fun mapToListOfSets(nestedLoopCount: Int, n: Int, source: ObservableEmitter<List<Int>>): Action {
    return if (nestedLoopCount < 1) {
        Action.Consumer(source)
    } else {
        Action.Wrapper(n, mapToListOfSets(nestedLoopCount - 1, n, source))
    }
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

