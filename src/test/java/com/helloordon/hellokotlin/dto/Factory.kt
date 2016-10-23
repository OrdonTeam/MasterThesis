package com.helloordon.hellokotlin.dto

fun function(argumentNames: List<String>, vararg rows: BooleanFunctionRow) = BooleanFunction(rows.toList(), argumentNames)

fun function(vararg rows: BooleanFunctionRow) = BooleanFunction(rows.toList())

fun row(decision: String, vararg arguments: Boolean) = BooleanFunctionRow(arguments.asList(), decision)

fun pair(x: Int, y: Int): Argument {
    return Argument.Single(x) with Argument.Single(y)
}

fun pair(x: Argument, y: Argument): Argument {
    return x with y
}

fun triplet(x: Int, y: Int, z: Int): Argument {
    return Argument.Triplet(Argument.Single(x), Argument.Single(y), Argument.Single(z))
}