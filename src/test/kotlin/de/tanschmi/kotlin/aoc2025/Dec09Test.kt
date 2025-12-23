package de.tanschmi.kotlin.aoc2025

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec09Test {

    val d = Dec09()

    @Test
    fun step1_exampleValue() {
        val input = """7,1
11,1
11,7
9,7
9,5
2,5
2,3
7,3"""

        val result = d.step1(input)
        assertEquals(50, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec09.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step1(input)
        assertEquals(4763040296L, result)

    }

    @Test
    fun step2_exampleValue() {
        val input = """7,1
11,1
11,7
9,7
9,5
2,5
2,3
7,3"""

        val result = d.step2(input)
        assertEquals(24L, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec09.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step2(input)
        assertEquals(0L, result)
    }

}