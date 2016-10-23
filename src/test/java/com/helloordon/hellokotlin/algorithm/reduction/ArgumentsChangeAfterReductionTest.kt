package com.helloordon.hellokotlin.algorithm.reduction

import org.junit.Assert
import org.junit.Test

class ArgumentsChangeAfterReductionTest {

    @Test
    fun shouldShowArgumentsChangeAfterReduction() {
        Assert.assertEquals(
                listOf("x0", "x1", "x3", "x4"),
                applyReductionOnArgumentNames(listOf("x0", "x1", "x2", "x3", "x4"), listOf(0, 1, 3, 4))
        )
    }
}