package de.tanschmi.kotlin.aoc2023.dec03

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec03Test {
    val d = Dec03()

    @Test
    fun step1_exampleInput() {
        val input = """
            467..114..
            ...*......
            ..35..633.
            ......#...
            617*......
            .....+.58.
            ..592.....
            ......755.
            ...$.*....
            .664.598..
        """.trimIndent()

        val result = d.step1(input)
        assertEquals(4361, result)

    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2023/dec03.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())
        assertNotNull(input)

        val result = d.step1(input)
        assertEquals(512794, result)

    }

}