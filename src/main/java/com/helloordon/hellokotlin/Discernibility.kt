package com.helloordon.hellokotlin

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