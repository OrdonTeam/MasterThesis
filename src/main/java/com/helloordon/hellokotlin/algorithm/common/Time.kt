package com.helloordon.hellokotlin.algorithm.common

fun measureTime(runnable: () -> Unit) {
    val start = System.currentTimeMillis()
    println(start)
    try {
        runnable()
    } finally {
        val end = System.currentTimeMillis()
        println(end)
        println("${(end - start) / 1000.0} sec")
    }

}