package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

fun listOfSets(setSize: Int): Observable<List<Int>> {
    return Observable.create { source ->
        try {
            (2..setSize).forEach { subSetSize ->
                createSetGenerator(subSetSize, setSize, source).generate()
            }
        } catch(e: InterruptedException) {
            //ok continue
        }
        source.onComplete()
    }
}

private fun createSetGenerator(nestedLoopCount: Int, n: Int, source: ObservableEmitter<List<Int>>): SetGenerator {
    return if (nestedLoopCount < 2) {
        SetGenerator.SingleElement(n, source)
    } else {
        SetGenerator.MultipleElements(n - (nestedLoopCount - 1), createSetGenerator(nestedLoopCount - 1, n, source))
    }
}

private sealed class SetGenerator {

    protected abstract fun appendSet(from: Int, setToAppend: List<Int>)

    class SingleElement(val to: Int, val source: ObservableEmitter<List<Int>>) : SetGenerator() {
        override fun appendSet(from: Int, setToAppend: List<Int>) {
            (from until to).forEach {
                if(source.isDisposed) throw InterruptedException()
                source.onNext(setToAppend + it)
            }
        }
    }

    class MultipleElements(val to: Int, val setGenerator: SetGenerator) : SetGenerator() {
        override fun appendSet(from: Int, setToAppend: List<Int>) {
            (from until to).forEach {
                setGenerator.appendSet(it + 1, setToAppend + it)
            }
        }
    }

    fun generate(): Unit {
        appendSet(0, emptyList())
    }
}

