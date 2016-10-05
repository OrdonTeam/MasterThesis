package com.helloordon.hellokotlin.util

fun <E> Iterable<E>.allPairs(): List<Pair<E, E>> {
    return this.toList().allPairs()
}

fun <E> List<E>.allPairs(): List<Pair<E, E>> {
    return (0 until size).flatMap { first ->
        ((first + 1) until size).map { second ->
            this[first] to this[second]
        }
    }
}

infix fun List<Int>.isDisjointWith(other: List<Int>): Boolean {
    return all { !other.contains(it) }
}