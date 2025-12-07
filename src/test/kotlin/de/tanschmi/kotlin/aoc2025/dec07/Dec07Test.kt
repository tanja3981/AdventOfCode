package de.tanschmi.kotlin.aoc2025.dec07

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec07Test {
    val d = Dec07()

    @Test
    fun step1_exampleInput() {
        val input = """.......S.......
...............
.......^.......
...............
......^.^......
...............
.....^.^.^.....
...............
....^.^...^....
...............
...^.^...^.^...
...............
..^...^.....^..
...............
.^.^.^.^.^...^.
..............."""

        val result = d.step1(input)
        assertEquals(21L, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec07.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step1(input)
        assertEquals(1546L, result)
    }

}