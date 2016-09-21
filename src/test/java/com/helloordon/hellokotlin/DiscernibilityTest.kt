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
        assertDiscernibility(
                listOf(false),
                listOf(false),
                listOf())
    }

    @Test
    fun shouldReturnFullDiscernibility() {
        assertDiscernibility(
                listOf(true),
                listOf(false),
                listOf(0))
        assertDiscernibility(
                listOf(false),
                listOf(true),
                listOf(0))
    }

    private fun assertDiscernibility(a: List<Boolean>, b: List<Boolean>, discernibility: List<Int>) {
        Assert.assertEquals(discernibility, findDiscernibility(a, b))
    }

    private fun findDiscernibility(vectorA: List<Boolean>, vectorB: List<Boolean>): List<Int> {
        return if (vectorA[0] == vectorB[0]) emptyList() else listOf(0)
    }
}