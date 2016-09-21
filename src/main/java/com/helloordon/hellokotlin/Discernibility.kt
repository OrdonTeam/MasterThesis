package com.helloordon.hellokotlin

fun findDiscernibility(vectorA: List<Boolean>, vectorB: List<Boolean>): List<Int> {
    return (0 until vectorA.size).filter {
        vectorA[it] != vectorB[it]
    }
}