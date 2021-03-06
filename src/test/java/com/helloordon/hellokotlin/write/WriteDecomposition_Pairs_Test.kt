package com.helloordon.hellokotlin.write

import com.helloordon.hellokotlin.dto.pair
import io.reactivex.Observable
import org.junit.After
import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.*

class WriteDecomposition_Pairs_Test {

    private val file = File(UUID.randomUUID().toString())

    @Test
    fun shouldSaveMissingPair() {
        file.writer().use { writer ->
            Observable.just(pair(0, 1))
                    .writeDecomposition(writer, 3)
                    .subscribe()
        }
        Assert.assertEquals(listOf("x0 * x1 + x2"), file.readLines())
    }

    @Test
    fun shouldSaveMissingPairs() {
        file.writer().use { writer ->
            Observable.just(pair(0, 1),pair(0, 2))
                    .writeDecomposition(writer, 3)
                    .subscribe()
        }
        Assert.assertEquals(listOf("x0 * x1 + x2", "x0 * x2 + x1"), file.readLines())
    }

    @Test
    fun shouldSaveMissingPairFor4Arguments() {
        file.writer().use { writer ->
            Observable.just(pair(0, 1))
                    .writeDecomposition(writer, 4)
                    .subscribe()
        }
        Assert.assertEquals(listOf("x0 * x1 + x2 + x3"), file.readLines())
    }

    @After
    fun tearDown() {
        file.delete()
    }
}
