package de.tanschmi.kotlin.aoc2025.dec01

import de.tanschmi.kotlin.FileReader
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Dec1Test {

    var dec1 = Dec1()

    @Test
    fun parseLine() {

        assertEquals(5, dec1.parseLine("R05"))
        assertEquals(-55, dec1.parseLine("L55"))
    }

    @Test
    fun dial1() {

        assertEquals(60, dec1.dial1(10))

        assertEquals(0, dec1.dial1(1, 99))

        assertEquals(0, dec1.dial1(-1, 1))

        assertEquals(-10, dec1.dial1(-60))
    }

    @Test
    fun testStep1_exampleInput() {
        var input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent()

        var expected: Long = 3

        var sum: Long = dec1.step1(input.lines())
        assertEquals(expected, sum)
    }

    @Test
    fun testStep1_realInput() {
        var file = File(ClassLoader.getSystemResource("2025inputs/dec1.txt").file)
        var lines = FileReader().readLines(file)
        var sum: Long = dec1.step1(lines)
        println("Summe: $sum")
        assertEquals(1086, sum)
    }

    @Test
    fun dial2() {
        assertEquals(Pair(1L, 82), dec1.dial2(-68))
        assertEquals(Pair(0L, 52), dec1.dial2(-30, 82))
        assertEquals(Pair(1L, 0), dec1.dial2(48, 52))
        assertEquals(Pair(0L, 95), dec1.dial2(-5, 0))
        assertEquals(Pair(1L, 55), dec1.dial2(60, 95))
        assertEquals(Pair(1L, 0), dec1.dial2(-55, 55))
        assertEquals(Pair(0L, 99), dec1.dial2(-1, 0))
        assertEquals(Pair(1L, 0), dec1.dial2(-99, 99))
        assertEquals(Pair(0L, 14), dec1.dial2(14, 0))
        assertEquals(Pair(1L, 32), dec1.dial2(-82, 14))



    }

    @Test
    fun beCareful() {
        assertEquals(Pair(10L, 50), dec1.dial2(1000, 50))

        assertEquals(Pair(8L, 54), dec1.dial2(-758, 12))
    }

    @Test
    fun step2_exampleInput() {
        var input = """
            L68
            L30
            R48
            L5
            R60
            L55
            L1
            L99
            R14
            L82
        """.trimIndent()

        val expected: Long = 6

        var sum: Long = dec1.step2(input.lines())
        assertEquals(expected, sum)
    }

    @Test
    fun testStep2_realInput() {
        var file = File(ClassLoader.getSystemResource("2025inputs/dec1.txt").file)
        var lines = FileReader().readLines(file)
        var sum: Long = dec1.step2(lines)
        println("Summe: $sum")
        assertEquals(6268, sum)
    }
}