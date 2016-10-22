package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.Argument
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import java.util.*

fun Observable<Argument>.findDisjointDecompositions(): Observable<Argument> {
    return compose({
        Observable.create<Argument> { source ->
            subscribe(DisjointObserver(source))
        }
    })
}

private class DisjointObserver(val source: ObservableEmitter<Argument>) : Observer<Argument> {
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