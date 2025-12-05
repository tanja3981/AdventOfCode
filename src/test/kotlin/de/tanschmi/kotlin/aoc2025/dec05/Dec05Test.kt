package de.tanschmi.kotlin.aoc2025.dec05

import de.tanschmi.kotlin.FileReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class Dec05Test {
    val d = Dec05()

    @Test
    fun step1_exampleInput() {
        val input = """
            3-5
            10-14
            16-20
            12-18

            1
            5
            8
            11
            17
            32
        """.trimIndent()

        val lines = input.lines()
        val result = d.step1(lines)
        assertEquals(3, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec05.txt").file)
        val lines = FileReader().readLines(file)

        val result = d.step1(lines)
        assertEquals(761, result)
    }

    @Test
    fun step2_exampleInput() {
        val input = """
            3-5
            10-14
            16-20
            12-18

            1
            5
            8
            11
            17
            32
        """.trimIndent()

        val lines = input.lines()
        val result = d.step2(lines)
        assertEquals(14L, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec05.txt").file)
        val lines = FileReader().readLines(file)

        val result = d.step2(lines)
        assertEquals(345755049374932L, result)
    }
}