package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.util.isDisjointWith
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

fun getSeparateFours(missingFours: Observable<Pair<List<Int>, List<Int>>>): Observable<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>> {
    return Observable.create { source ->
        missingFours.subscribe(SeparateFoursConsumer(source))
    }
}

private class SeparateFoursConsumer(val source: ObservableEmitter<Pair<Pair<List<Int>, List<Int>>, Pair<List<Int>, List<Int>>>>) : Observer<Pair<List<Int>, List<Int>>> {
    val buffer = ArrayList<Pair<List<Int>, List<Int>>>()

    override fun onSubscribe(d: Disposable) {
        source.setDisposable(d)
    }

    override fun onNext(next: Pair<List<Int>, List<Int>>) {
        buffer.forEach {
            if ((it.first + it.second) isDisjointWith (next.first + next.second)) {
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