package de.tanschmi.kotlin.aoc2025

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
            162,817,812
            57,618,57
            906,360,560
            592,479,940
            352,342,300
            466,668,158
            542,29,236
            431,825,988
            739,650,466
            52,470,668
            216,146,977
            819,987,18
            117,168,530
            805,96,715
            346,949,466
            970,615,88
            941,993,340
            862,61,35
            984,92,344
            425,690,689
        """.trimIndent()

        val result = d.step1(input, 10)
        assertEquals(40, result)
    }

    @Test
    fun step1() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec08.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step1(input, 1000)
        assertEquals(133574, result)

    }

    @Test
    fun step2_exampleValue() {
        val input = """
            162,817,812
            57,618,57
            906,360,560
            592,479,940
            352,342,300
            466,668,158
            542,29,236
            431,825,988
            739,650,466
            52,470,668
            216,146,977
            819,987,18
            117,168,530
            805,96,715
            346,949,466
            970,615,88
            941,993,340
            862,61,35
            984,92,344
            425,690,689
        """.trimIndent()

        val result = d.step2(input)
        assertEquals(25272, result)
    }

    @Test
    fun step2() {
        val file = File(ClassLoader.getSystemResource("2025inputs/dec08.txt").file)
        val input = FileUtils.readFileToString(file, Charset.defaultCharset())

        val result = d.step2(input)
        assertEquals(2435100380L, result)
    }


}