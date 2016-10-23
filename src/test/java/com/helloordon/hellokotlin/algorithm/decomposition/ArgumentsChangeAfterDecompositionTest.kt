package com.helloordon.hellokotlin.algorithm.decomposition

import org.junit.Assert
import org.junit.Test

class ArgumentsChangeAfterDecompositionTest {

    @Test
    fun shouldShowArgumentsChangeAfterDecomposition() {
        Assert.assertEquals(
                listOf("x2", "x3", "x4", "x0 ⊕ x1"),
                applyDecompositionOnArgumentNames(listOf("x0", "x1", "x2", "x3", "x4"), listOf(0, 1))
        )
    }

    fun applyDecompositionOnArgumentNames(argumentNames: List<String>, decompostion: List<Int>): List<String> {
        return notInDecomposition(argumentNames, decompostion) +
                afterDecomposition(argumentNames, decompostion)
    }

    private fun notInDecomposition(argumentNames: List<String>, decompostion: List<Int>): List<String> {
        return argumentNames.filterIndexed { index, s -> !decompostion.contains(index) }
    }

    private fun afterDecomposition(argumentNames: List<String>, decompostion: List<Int>): List<String> {
        val included = argumentNames.filterIndexed { index, s -> decompostion.contains(index) }
        return included.dropLast(1).zip(included.drop(1)).map {
            "${it.first} ⊕ ${it.second}"
        }
    }
}