package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class DiscernibilityTest {

    @Test
    fun shouldReturnEmptyDiscernibility() {
        assertDiscernibility(
                listOf(true),
                listOf(true),
                listOf())
    }

    @Test
    fun shouldReturnFullDiscernibility() {
        assertDiscernibility(
                listOf(true),
                listOf(false),
                listOf(0))
    }

    private fun assertDiscernibility(a: List<Boolean>, b: List<Boolean>, discernibility: List<Int>) {
        Assert.assertEquals(discernibility, findDiscernibility(a, b))
    }

    private fun findDiscernibility(vectorA: List<Boolean>, vectorB: List<Boolean>): List<Int> {
        return if (vectorB[0]) emptyList() else listOf(0)
    }
}