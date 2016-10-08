package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.pair
import io.reactivex.Observable
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteDecomposition_Fours_Test {

    val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldSaveMissingFour() {
        file.writer().use { writer ->
            Observable.just(pair(pair(0, 1), pair(2, 3)))
                    .writeDecomposition(writer, 4)
                    .subscribe()
        }
        Assert.assertEquals(listOf("(x0 * x1) * (x2 * x3)"), file.readLines())
    }

    @Test
    fun shouldSaveMissingFours() {
        file.writer().use { writer ->
            Observable.just(pair(pair(0, 1), pair(2, 3)), pair(pair(1, 2), pair(3, 4)))
                    .writeDecomposition(writer, 5)
                    .subscribe()
        }
        Assert.assertEquals(listOf("(x0 * x1) * (x2 * x3) + x4", "(x1 * x2) * (x3 * x4) + x0"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
