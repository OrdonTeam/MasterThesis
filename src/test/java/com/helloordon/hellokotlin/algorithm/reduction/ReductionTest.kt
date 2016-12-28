package com.helloordon.hellokotlin.algorithm.reduction

import com.helloordon.hellokotlin.dto.function
import com.helloordon.hellokotlin.dto.row
import org.junit.Assert
import org.junit.Test

class ReductionTest {

    @Test
    fun shouldFindBestArgumentToReduction() {
        verifyBestArgument(0, listOf(listOf(0)))
        verifyBestArgument(1, listOf(listOf(1)))
        verifyBestArgument(0, listOf(listOf(1), listOf(0), listOf(0)))
        verifyBestArgument(2, listOf(listOf(0, 1, 2), listOf(0, 1), listOf(2)))
    }

    private fun verifyBestArgument(expected: Int, discernibility: List<List<Int>>) {
        Assert.assertEquals(expected, findBestArgumentToReduction(discernibility))
    }

    @Test
    fun shouldRemoveRowsByArgument() {
        Assert.assertEquals(emptyList<Int>(), removeRowsFromDiscernibility(listOf(listOf(0)), 0))
        Assert.assertEquals(listOf(listOf(0)), removeRowsFromDiscernibility(listOf(listOf(0)), 1))
    }

    @Test
    fun shouldFindReduct() {
        Assert.assertEquals(listOf(0), findReduct(listOf(listOf(0, 1), listOf(0, 2))))
        Assert.assertEquals(listOf(1), findReduct(listOf(listOf(0, 1), listOf(1, 2))))
        Assert.assertEquals(listOf(1, 2), findReduct(listOf(listOf(1), listOf(2))))
    }

    @Test
    fun shouldReduceFunctionArguments() {
        Assert.assertEquals(
                function(
                        listOf("x1", "x2", "x3"),
                        row("0", true, false, false),
                        row("1", false, true, false),
                        row("2", false, false, true),
                        row("3", false, false, false)),
                function(
                        listOf("x0", "x1", "x2", "x3", "x4"),
                        row("0", false, true, false, false, false),
                        row("1", false, false, true, false, false),
                        row("2", false, false, false, true, false),
                        row("3", false, false, false, false, true)).reduceArguments())
    }

    @Test
    fun shouldRemoveRedundantRows() {
        Assert.assertEquals(
                function(
                        listOf("x2"),
                        row("0", false),
                        row("1", true)),
                function(
                        listOf("x1", "x2"),
                        row("0", false, false),
                        row("0", true, false),
                        row("1", false, true)).reduceArguments())
    }

    @Test
    fun shouldRemoveRedundantAttributesFromReduct() {
        Assert.assertEquals(listOf(1, 3), findMinimalReduct(listOf(
                listOf(0, 1),
                listOf(0, 3),
                listOf(0, 3),
                listOf(1, 2),
                listOf(3, 4)
        )))
    }

    @Test
    fun shouldRemoveAllRedundantAttributes() {
        Assert.assertEquals(emptyList<Int>(), listOf(0, 1, 2, 3).removeRedundantAttributes(emptyList()))
    }

    @Test
    fun shouldRemoveSecondAttributeIfIsRedundant() {
        Assert.assertEquals(listOf(0), listOf(0, 1).removeRedundantAttributes(listOf(listOf(0))))
    }
}
