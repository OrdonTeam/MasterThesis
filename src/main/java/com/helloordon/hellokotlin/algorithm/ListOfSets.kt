package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

fun listOfSets(setSize: Int): Observable<List<Int>> {
    return Observable.create { source ->
        (2..setSize).forEach { subSetSize ->
            createSetGenerator(subSetSize, setSize, source).generate()
        }
        source.onComplete()
    }
}

private fun createSetGenerator(nestedLoopCount: Int, n: Int, source: ObservableEmitter<List<Int>>): Generator {
    return if (nestedLoopCount < 2) {
        Generator.Consumer(n, source)
    } else {
        Generator.Wrapper(n, createSetGenerator(nestedLoopCount - 1, n, source))
    }
}

private sealed class Generator {

    protected abstract fun appendSet(from: Int, setToAppend: List<Int>)

    class Consumer(val to: Int, val source: ObservableEmitter<List<Int>>) : Generator() {
        override fun appendSet(from: Int, setToAppend: List<Int>) {
            (from until to).forEach {
                source.onNext(setToAppend + it)
            }
        }
    }

    class Wrapper(val to: Int, val generator: Generator) : Generator() {
        override fun appendSet(from: Int, setToAppend: List<Int>) {
            (from until to).forEach {
                generator.appendSet(it + 1, setToAppend + it)
            }
        }
    }

    fun generate(): Unit {
        appendSet(0, emptyList())
    }
}

