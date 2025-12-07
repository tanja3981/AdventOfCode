package de.tanschmi.kotlin.aoc2025.dec08

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec08Test {
    val d = Dec08()

    @Test
    fun step1_exampleValue() {
        val input = """
            
        """.trimIndent()

        val result = d.step1(input)
        assertEquals(0, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec07.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step1(input)
        assertEquals(0, result)

    }

    @Test
    fun step2_exampleValue() {
        val input = """
            
        """.trimIndent()

        val result = d.step2(input)
        assertEquals(0, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec07.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step2(input)
        assertEquals(0, result)
    }


}