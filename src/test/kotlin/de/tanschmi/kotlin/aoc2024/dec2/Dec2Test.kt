package de.tanschmi.kotlin.aoc2024.dec2

import de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.dec2.Sequence
import de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.dec2.Task1
import de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.dec2.Task2
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue

class Task1Test {
    var dec2 = Task1()

    @Test
    fun testStep1() {
        var expected = 432;
        var f = File(ClassLoader.getSystemResource("inputs/dec2.txt").file);

        assertEquals(expected, dec2.task1(f));
    }

    @Test
    fun testSafe1_1() {
        var seq = sequence(7, 6, 4, 2, 1)
        assertTrue(dec2.isSafeSequence(seq))
    }

    @Test
    fun testSafe1_2() {
        var seq = sequence(1, 2, 7, 8, 9)
        assertFalse(dec2.isSafeSequence(seq))
    }

    @Test
    fun testSafe1_3() {
        var seq = sequence(9, 7, 6, 2, 1)
        assertFalse(dec2.isSafeSequence(seq))
    }

    @Test
    fun testSafe1_4() {
        var seq = sequence(1, 3, 2, 4, 5)
        assertFalse(dec2.isSafeSequence(seq))
    }

    @Test
    fun testSafe1_5() {
        var seq = sequence(8, 6, 4, 4, 1)
        assertFalse(dec2.isSafeSequence(seq))
    }

    @Test
    fun testSafe1_6() {
        var seq = sequence(1, 3, 6, 7, 9)
        assertTrue(dec2.isSafeSequence(seq))
    }
}

class Task2Test {
    var dec2 = Task2()

    @Test
    fun testTask() {
        var expected = 488
        var f = File(ClassLoader.getSystemResource("inputs/dec2.txt").file);

        assertEquals(expected, dec2.task2(f));
    }

    @Test
    fun test1() {
        var seq = sequence(7, 6, 4, 2, 1)
        assertTrue(dec2.isSafeSequence(seq))
    }

    @Test
    fun test2() {
        var seq = sequence(1, 2, 7, 8, 9)
        assertFalse(dec2.isSafeSequence(seq))
    }

    @Test
    fun test3() {
        assertFalse(dec2.isSafeSequence(sequence(9, 7, 6, 2, 1)))
    }

    @Test
    fun test4() {
        assertTrue(dec2.isSafeSequence(sequence(1, 3, 2, 4, 5)))
    }

    @Test
    fun test5() {
        assertTrue(dec2.isSafeSequence(sequence(8, 6, 4, 4, 1)))
    }

    @Test
    fun test6() {
        assertTrue(dec2.isSafeSequence(sequence(1, 3, 6, 7, 9)))
    }
}

private fun sequence(i: Int, i1: Int, i2: Int, i3: Int, i4: Int): Sequence {
    var seq = Sequence()
    seq.numbers = ArrayList<Int>(listOf(i, i1, i2, i3, i4))
    return seq
}