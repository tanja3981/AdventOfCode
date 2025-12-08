package de.tanschmi.kotlin.aoc2025

import de.tanschmi.kotlin.FileReader
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File

class Dec03Test {

    val d = Dec03()

    @Test
    fun findInLine_987654321111111() {
        val result = d.findInLine("987654321111111")
        assertEquals(98L, result)
    }

    @Test
    fun findInLine_811111111111119() {
        val result = d.findInLine("811111111111119")
        assertEquals(89L, result)
    }

    @Test
    fun findInLine_234234234234278() {
        val result = d.findInLine("234234234234278")
        assertEquals(78L, result)
    }

    @Test
    fun findInLine_818181911112111() {
        val result = d.findInLine("818181911112111")
        assertEquals(92L, result)
    }

    @Test
    fun step1_exampleInput() {
        val input = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
        """.trimIndent()

        val result = d.step1(input.lines())
        assertNotNull(result)
        assertEquals(357, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec03.txt").file)
        val lines = FileReader().readLines(file)

        val result = d.step1(lines)
        assertEquals(17142, result)
    }

    @Test
    fun findInLine12_987654321111111() {
        val result = d.findInLine("987654321111111", 12)
        assertEquals(987654321111L, result)
    }

    @Test
    fun findInLine12_811111111111119() {
        val result = d.findInLine("811111111111119", 12)
        assertEquals(811111111119L, result)
    }

    @Test
    fun findInLine12_234234234234278() {
        val result = d.findInLine("234234234234278", 12)
        assertEquals(434234234278L, result)
    }

    @Test
    fun findInLine12_818181911112111() {
        val result = d.findInLine("818181911112111", 12)
        assertEquals(888911112111L, result)
    }

    @Test
    fun step2_exampleInput() {
        val input = """
            987654321111111
            811111111111119
            234234234234278
            818181911112111
        """.trimIndent()

        val result = d.step2(input.lines())
        assertNotNull(result)
        assertEquals(3121910778619L, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec03.txt").file)
        val lines = FileReader().readLines(file)

        val result = d.step2(lines)
        assertEquals(169935154100102, result)
    }
}