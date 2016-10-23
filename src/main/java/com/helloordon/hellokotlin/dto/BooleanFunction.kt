package com.helloordon.hellokotlin.dto

data class BooleanFunction(val data: List<BooleanFunctionRow>, val argumentNames: List<String>) {

    constructor(data: List<BooleanFunctionRow>) : this(data, defaultArgumentsNames(data.first().arguments.count()))

    fun asMap(): Map<String, List<List<Boolean>>> {
        return data.groupBy(BooleanFunctionRow::decision, BooleanFunctionRow::arguments)
    }

    fun getArgumentCount() = data.first().arguments.count()
}

data class BooleanFunctionRow(
        val arguments: List<Boolean>,
        val decision: String)

fun defaultArgumentsNames(argumentCount: Int): List<String> {
    return (0 until argumentCount).map { "x$it" }
}
