package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

fun Observable<Argument>.toSeparatePairs(): Observable<Argument> {
    return compose(::getSeparatePairs)
}

private fun getSeparatePairs(missingPairs: Observable<Argument>): Observable<Argument> {
    return Observable.create { source ->
        missingPairs.subscribe(SeparatePairsConsumer(source))
    }
}

private class SeparatePairsConsumer(val source: ObservableEmitter<Argument>) : Observer<Argument> {
    val buffer = ArrayList<Argument>()

    override fun onSubscribe(d: Disposable) {
        source.setDisposable(d)
    }

    override fun onNext(next: Argument) {
        buffer.forEach {
            if (it isDisjointWith next) {
                source.onNext(it with next)
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