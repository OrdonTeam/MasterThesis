package com.helloordon.hellokotlin.dto

fun pair(x: Int, y: Int) = Argument.Single(x) with Argument.Single(y)

fun pair(x: Argument, y: Argument) = x with y