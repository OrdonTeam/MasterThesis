package com.helloordon.hellokotlin

import org.junit.Assert.assertEquals
import org.junit.Test

class ListOfSetsTest {

    @Test
    fun shouldReturnEmpty() {
        assertEquals(expected = emptyList(), givenN = 1)
    }

    @Test
    fun shouldReturnAllPairs() {
        assertEquals(expected = listOf(listOf(0, 1)), givenN = 2)
    }

    @Test
    fun shouldReturnAllPairsAndTriples() {
        assertEquals(expected = listOf(listOf(0, 1), listOf(0, 2), listOf(1, 2), listOf(0, 1, 2)), givenN = 3)
    }

    @Test
    fun shouldReturnAllPairsTriplesAndFours() {
        assertEquals(expected = listOf(
                listOf(0, 1), listOf(0, 2), listOf(0, 3),
                listOf(1, 2), listOf(1, 3), listOf(2, 3),
                listOf(0, 1, 2), listOf(0, 1, 3), listOf(0, 2, 3), listOf(1, 2, 3),
                listOf(0, 1, 2, 3)), givenN = 4)
    }

    private fun assertEquals(expected: List<List<Int>>, givenN: Int) {
        assertEquals(expected.toSet(), listOfSets(givenN).toSet())
    }

    private fun listOfSets(n: Int): List<List<Int>> {
        return listOfRanges(n).flatMap(mapToListOfSets(n))
    }

    private fun listOfRanges(n: Int) = (1 until n).map { 0..it }

    private fun mapToListOfSets(n: Int): (IntRange) -> List<List<Int>> {
        val initial: (Int, List<Int>) -> List<List<Int>> = { a, list -> listOf(list) }
        return {
            it.fold(initial, operation(n)).get()
        }
    }


    fun operation(n: Int): ((Int, List<Int>) -> List<List<Int>>, Int) -> (Int, List<Int>) -> List<List<Int>> = { action, i ->
        forFun(n - i).invoke(action)
    }

    fun forFun(to: Int): ((Int, List<Int>) -> List<List<Int>>) -> (Int, List<Int>) -> List<List<Int>> {
        return { action ->
            { from, list ->
                (from until to).flatMap {
                    action(it + 1, list + it)
                }
            }
        }
    }

    private fun ((Int, List<Int>) -> List<List<Int>>).get(): List<List<Int>> {
        return this.invoke(0, emptyList())
    }
}

