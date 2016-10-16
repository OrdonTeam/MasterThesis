package com.helloordon.hellokotlin.algorithm

import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.dto.BooleanFunctionRow
import org.junit.Assert
import org.junit.Test

class ApplyDecompositionTest {

    @Test
    fun shouldApplyTwoArgumentDecompositionOnTwoArgumentFunction() {
        verify(expected = function(row("0", false), row("1", true), row("1", true), row("0", false)),
                function = function(row("0", false, false), row("1", true, false), row("1", false, true), row("0", true, true)),
                decomposition = listOf(0, 1))
    }

    @Test
    fun shouldApplyTwoArgumentDecompositionOnThreeArgumentFunction() {
        verify(
                expected = function(
                        row("0", false, false),
                        row("1", true, true),
                        row("1", true, true),
                        row("1", true, false),
                        row("0", false, false)),
                function = function(
                        row("0", false, false, false),
                        row("1", true, true, false),
                        row("1", true, false, true),
                        row("1", true, true, true),
                        row("0", false, true, true)),
                decomposition = listOf(1, 2))
    }

    private fun function(vararg rows: BooleanFunctionRow) = BooleanFunction(rows.toList())

    private fun row(decision: String, vararg arguments: Boolean) = BooleanFunctionRow(arguments.asList(), decision)

    private fun verify(expected: BooleanFunction, function: BooleanFunction, decomposition: List<Int>) {
        Assert.assertEquals(expected, function.applyDecomposition(decomposition))
    }
}

private fun BooleanFunction.applyDecomposition(decomposition: List<Int>): BooleanFunction {
    return BooleanFunction(data.map { it.applyDecomposition(decomposition) })
}

private fun BooleanFunctionRow.applyDecomposition(decomposition: List<Int>): BooleanFunctionRow {
    return copy(arguments.applyDecomposition(decomposition))
}

private fun List<Boolean>.applyDecomposition(decomposition: List<Int>): List<Boolean> {
    return filterIndexed { i, b -> !decomposition.contains(i) } + get(decomposition[0]).xor(get(decomposition[1]))
}
