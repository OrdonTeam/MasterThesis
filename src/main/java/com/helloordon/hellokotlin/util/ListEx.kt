package com.helloordon.hellokotlin.util

infix fun List<Int>.isDisjointWith(other: List<Int>): Boolean {
    return all { !other.contains(it) }
}