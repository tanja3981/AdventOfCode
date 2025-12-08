package de.tanschmi.kotlin.aoc2025

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec04Test {
    val d: Dec04 = Dec04()

    @Test
    fun step1_exampleInput() {
        val input = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
        """.trimIndent()

        val result = d.step1(input)
        assertEquals(13, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec04.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step1(input)
        assertEquals(1602, result)
    }

    @Test
    fun step2_exampleInput() {
        val input = """
            ..@@.@@@@.
            @@@.@.@.@@
            @@@@@.@.@@
            @.@@@@..@.
            @@.@@@@.@@
            .@@@@@@@.@
            .@.@.@.@@@
            @.@@@.@@@@
            .@@@@@@@@.
            @.@.@@@.@.
        """.trimIndent()

        val result = d.step2(input)
        assertEquals(43, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec04.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step2(input)
        assertEquals(9518, result)
    }
}