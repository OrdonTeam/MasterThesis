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
}