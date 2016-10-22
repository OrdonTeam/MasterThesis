package com.helloordon.hellokotlin.algorithm.decomposition

import org.junit.Assert
import org.junit.Test

class MatrixDiscernibilitySingleTest {

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

    @Test
    fun shouldReturnMixedDiscernibility() {
        assertDiscernibility(
                listOf(true, true),
                listOf(true, false),
                listOf(1))
        assertDiscernibility(
                listOf(false, true),
                listOf(true, true),
                listOf(0))
    }

    private fun assertDiscernibility(a: List<Boolean>, b: List<Boolean>, discernibility: List<Int>) {
        Assert.assertEquals(discernibility, findDiscernibility(a, b))
    }
}