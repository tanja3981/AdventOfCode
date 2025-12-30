package de.tanschmi.kotlin.aoc2025

import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.File
import java.nio.charset.Charset

class Dec10Test {
    @Test
    fun step1_firstLine() {

        val input = "[.##.] (3) (1,3) (2) (2,3) (0,2) (0,1) {3,5,4,7}"

        val result = Dec10().step1(input)
        assertEquals(2, result)

    }

    @Test
    fun redditExample() {
        assertEquals(1, Dec10().step1("[#...] (0) (1) (2) (3) {1,1,1,1}"))
        assertEquals(1, Dec10().step1("[.#..] (0) (1) (2) (3) {1,1,1,1}"))
        assertEquals(1, Dec10().step1("[..#.] (0) (1) (2) (3) {1,1,1,1}"))
        assertEquals(1, Dec10().step1("[...#] (0) (1) (2) (3) {1,1,1,1}"))

        assertEquals(3, Dec10().step1("[#...] (1,2,3) (0,2,3) (0,1,3) (0,1,2) {1,1,1,1}"))
        assertEquals(3, Dec10().step1("[.#..] (1,2,3) (0,2,3) (0,1,3) (0,1,2) {1,1,1,1}"))
        assertEquals(3, Dec10().step1("[..#.] (1,2,3) (0,2,3) (0,1,3) (0,1,2) {1,1,1,1}"))
        assertEquals(3, Dec10().step1("[...#] (1,2,3) (0,2,3) (0,1,3) (0,1,2) {1,1,1,1}"))
    }

    @Test
    fun step1_Line2() {

        val input = "[...#.] (0,2,3,4) (2,3) (0,4) (0,1,2) (1,2,3,4) {7,5,12,7,2}"
//((0,4), (0,1,2), and (1,2,3,4)) once each
        //1,
        val result = Dec10().step1(input)
        assertEquals(3, result)

    }

    @Test
    fun step1_line3() {
        val input = "[.###.#] (0,1,2,3,4) (0,3,4) (0,1,2,4,5) (1,2) {10,11,11,5,10,5}"
        val result = Dec10().step1(input)
        assertEquals(2, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec10.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = Dec10().step1(input)
        assertEquals(401L, result)
    }

}