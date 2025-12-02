package de.tanschmi.kotlin.aoc2023.dec04

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec04Test {
    val d = Dec04()

    @Test
    fun step1_exampleInput() {
        val input = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
        """.trimIndent()

        val result = d.step1(input)
        assertEquals(13, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2023/dec04.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())
        assertNotNull(input)

        val result = d.step1(input)
        assertEquals(22488, result)
    }

    @Test
    fun step2_exampleInput() {
        val input = """
            Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53
            Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19
            Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1
            Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83
            Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36
            Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11
        """.trimIndent()

        val result = d.step2(input)
        assertEquals(30, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2023/dec04.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())
        assertNotNull(input)

        val result = d.step2(input)
        assertEquals(7013204, result)
    }
}