package com.helloordon.hellokotlin.algorithm.decomposition

import com.helloordon.hellokotlin.dto.BooleanFunction
import com.helloordon.hellokotlin.dto.function
import com.helloordon.hellokotlin.dto.row
import org.junit.Assert
import org.junit.Test

class ApplyDecompositionTest {

    @Test
    fun shouldApplyTwoArgumentDecompositionOnTwoArgumentFunction() {
        verifyData(expected = function(row("0", false), row("1", true), row("1", true), row("0", false)),
                function = function(row("0", false, false), row("1", true, false), row("1", false, true), row("0", true, true)),
                decomposition = listOf(0, 1))
    }

    @Test
    fun shouldApplyTwoArgumentDecompositionOnThreeArgumentFunction() {
        verifyData(
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

    @Test
    fun shouldApplyThreeArgumentDecompositionOnThreeArgumentFunction() {
        verifyData(
                expected = function(
                        row("0", false, false),
                        row("0", false, true),
                        row("0", true, true),
                        row("0", true, false)),
                function = function(
                        row("0", false, false, false),
                        row("0", false, false, true),
                        row("0", false, true, false),
                        row("0", true, false, false)),
                decomposition = listOf(0, 1, 2))
    }

    @Test
    fun shouldApplyDecompositionOnArgumentNames() {
        verify(
                expected = function(
                        listOf("x3", "x0 ⊕ x1", "x1 ⊕ x2"),
                        row("0", false, false, false)),
                function = function(
                        listOf("x0", "x1", "x2", "x3"),
                        row("0", false, false, false, false)),
                decomposition = listOf(0, 1, 2))
    }

    private fun verifyData(expected: BooleanFunction, function: BooleanFunction, decomposition: List<Int>) {
        Assert.assertEquals(expected.data, function.applyDecomposition(decomposition).data)
    }

    private fun verify(expected: BooleanFunction, function: BooleanFunction, decomposition: List<Int>) {
        Assert.assertEquals(expected, function.applyDecomposition(decomposition))
    }
}

