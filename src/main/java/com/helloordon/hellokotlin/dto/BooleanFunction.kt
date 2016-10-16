package com.helloordon.hellokotlin.dto

data class BooleanFunction(
        val data: List<BooleanFunctionRow>) {

    fun asMap(): Map<String, List<List<Boolean>>> {
        return data.groupBy(BooleanFunctionRow::decision, BooleanFunctionRow::arguments)
    }
}

data class BooleanFunctionRow(
        val arguments: List<Boolean>,
        val decision: String)
