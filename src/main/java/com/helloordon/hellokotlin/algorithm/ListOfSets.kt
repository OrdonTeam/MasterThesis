package com.helloordon.hellokotlin.algorithm

import io.reactivex.Observable

fun listOfSets(n: Int): Observable<List<Int>> {
    return Observable.fromIterable(listOfRanges(n).flatMap(mapToListOfSets(n)))
}

private fun listOfRanges(n: Int) = (1 until n).map { 0..it }

private fun mapToListOfSets(n: Int): (IntRange) -> List<List<Int>> {
    val initial: (Int, List<Int>) -> List<List<Int>> = { a, list -> listOf(list) }
    return {
        it.fold(initial, operation(n)).get()
    }
}

private fun operation(n: Int): ((Int, List<Int>) -> List<List<Int>>, Int) -> (Int, List<Int>) -> List<List<Int>> = { action, i ->
    forFun(n - i).invoke(action)
}

private fun forFun(to: Int): ((Int, List<Int>) -> List<List<Int>>) -> (Int, List<Int>) -> List<List<Int>> {
    return { action ->
        { from, list ->
            (from until to).flatMap {
                action(it + 1, list + it)
            }
        }
    }
}

private fun ((Int, List<Int>) -> List<List<Int>>).get(): List<List<Int>> {
    return this.invoke(0, emptyList())
}