package de.tanschmi.kotlin.aoc2025.dec06

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec06Test {
    val d = Dec06()
    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec06.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step1(input)
        assertEquals(6891729672676L, result)
    }

    @Test
    fun step1_exampleValue() {
        val input = """
            123 328  51 64 
             45 64  387 23 
              6 98  215 314
            *   +   *   +  
        """.trimIndent()

        val result = d.step1(input)
        assertEquals(4277556L, result)
    }

}