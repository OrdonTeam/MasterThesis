package com.helloordon.hellokotlin.dto

import com.helloordon.hellokotlin.util.isDisjointWith

sealed class Argument() {

    infix fun isDisjointWith(second: Argument): Boolean {
        return asList() isDisjointWith second.asList()
    }

    abstract fun asList(): List<Int>

    infix fun with(second: Argument) = Argument.Pair(this, second)

    class Single(val x: Int) : Argument() {
        override fun asList(): List<Int> {
            return listOf(x)
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other?.javaClass != javaClass) return false

            other as Single

            if (x != other.x) return false

            return true
        }

        override fun hashCode(): Int {
            return x
        }

        override fun toString(): String {
            return "x=$x"
        }
    }


    class Pair(val first: Argument, val second: Argument) : Argument() {
        override fun asList(): List<Int> {
            return first.asList() + second.asList()
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other?.javaClass != javaClass) return false

            other as Pair

            if (first != other.first) return false
            if (second != other.second) return false

            return true
        }

        override fun hashCode(): Int {
            var result = first.hashCode()
            result = 31 * result + second.hashCode()
            return result
        }

        override fun toString(): String {
            return "($first $second)"
        }
    }
}
