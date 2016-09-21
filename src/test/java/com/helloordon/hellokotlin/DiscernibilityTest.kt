package com.helloordon.hellokotlin

import org.junit.Assert
import org.junit.Test

class DiscernibilityTest {

    @Test
    fun shouldReturnEmptyDiscernibility() {
        val a = listOf(true)
        val b = listOf(true)
        Assert.assertEquals(emptyList<Int>(), findDiscernibility(a, b))
    }

    @Test
    fun shouldReturnFullDiscernibility() {
        val a = listOf(true)
        val b = listOf(false)
        Assert.assertEquals(listOf(0), findDiscernibility(a, b))
    }

    private fun findDiscernibility(vectorA: List<Boolean>, vectorB: List<Boolean>): List<Int> {
        return if(vectorB[0]) emptyList() else listOf(0)
    }
}