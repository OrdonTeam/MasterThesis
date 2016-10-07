package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.isDisjointWith
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

fun Observable<List<Int>>.toSeparatePairs(): Observable<Pair<List<Int>, List<Int>>> {
    return compose(::getSeparatePairs)
}

private fun getSeparatePairs(missingPairs: Observable<List<Int>>): Observable<Pair<List<Int>, List<Int>>> {
    return Observable.create { source ->
        missingPairs.subscribe(SeparatePairsConsumer(source))
    }
}

private class SeparatePairsConsumer(val source: ObservableEmitter<Pair<List<Int>, List<Int>>>) : Observer<List<Int>> {
    val buffer = ArrayList<List<Int>>()

    override fun onSubscribe(d: Disposable) {
        source.setDisposable(d)
    }

    override fun onNext(next: List<Int>) {
        buffer.forEach {
            if (it isDisjointWith next) {
                source.onNext(it to next)
            }
        }
        buffer.add(next)
    }

    override fun onComplete() {
        source.onComplete()
    }

    override fun onError(t: Throwable) {
        source.onError(t)
    }
}