package de.tanschmi.kotlin.aoc2024.dec1

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Dec1Test{
    var dec1 = Dec1()

    @Test
    fun testDec1(){
        var expected: Long = 1603498

        var input = File(ClassLoader.getSystemResource("inputs/dec1.txt").file)
        var sum: Long = dec1.step1(input)
        assertEquals(expected, sum)
    }

    @Test
    fun testDec2() {
        var expected: Long = 25574739

        var input = File(ClassLoader.getSystemResource("inputs/dec1.txt").file)
        var sum = dec1.step2(input)
        assertEquals(expected, sum)
    }
}