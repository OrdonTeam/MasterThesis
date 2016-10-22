package com.helloordon.hellokotlin.algorithm.decomposition

fun findDiscernibility(vectorA: List<Boolean>, vectorB: List<Boolean>) =
        (0 until vectorA.size).filter {
            vectorA[it] != vectorB[it]
        }

fun findMatrixDiscernibility(groupA: List<List<Boolean>>, groupB: List<List<Boolean>>) =
        groupA.flatMap { vectorA ->
            groupB.map { vectorB ->
                findDiscernibility(vectorA, vectorB)
            }
        }


fun findMatrixDiscernibility(groups: List<List<List<Boolean>>>) =
        (0 until groups.size).flatMap { first ->
            ((first + 1) until groups.size).flatMap { second ->
                findMatrixDiscernibility(groups[first], groups[second])
            }
        }