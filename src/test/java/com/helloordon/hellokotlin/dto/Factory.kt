package com.helloordon.hellokotlin.dto

fun pair(x: Int, y: Int): Argument {
    return Argument.Single(x) with Argument.Single(y)
}

fun pair(x: Argument, y: Argument): Argument {
    return x with y
}

fun triplet(x: Int, y: Int, z: Int): Argument {
    return pair(x, y)
}