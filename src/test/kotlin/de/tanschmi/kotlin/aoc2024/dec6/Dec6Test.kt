package de.tanschmi.kotlin.aoc2024.dec6

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File
import java.nio.charset.Charset

class Dec6Test {
    var dec6 = Dec6()

    @Test
    fun task1_exampleInput() {
        val example = """....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#..."""

        var result = dec6.task1(example)
        assertEquals(41, result)
    }

    @Test
    fun task1() {
        var f = File(ClassLoader.getSystemResource("inputs/dec6.txt").file)
        var input = FileUtils.readFileToString(f, Charset.defaultCharset())

        var result: Int = dec6.task1(input)
        kotlin.test.assertEquals(4663, result)
    }

    @Test
    fun task2_exampleInput() {
        val example = """....#.....
.........#
..........
..#.......
.......#..
..........
.#..^.....
........#.
#.........
......#..."""

        var result = dec6.task2(example)
        assertEquals(6, result)
    }

    @Test
    fun task2() {
        var f = File(ClassLoader.getSystemResource("inputs/dec6.txt").file)
        var input = FileUtils.readFileToString(f, Charset.defaultCharset())

        var result: Int = dec6.task2(input)
        kotlin.test.assertEquals(1530, result)
    }
}