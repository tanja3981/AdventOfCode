import de.tanschmi.kotlin.aoc2024.Dec2
import de.tanschmi.kotlin.aoc2024.Sequence
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import java.io.File
import kotlin.test.Test
import kotlin.test.assertTrue

class Dec2Test {
    var dec2 = Dec2()

    @Test
    fun testStep1() {
        var expected = 432;
        var f = File(ClassLoader.getSystemResource("inputs/dec2.txt").file);

        assertEquals(expected, dec2.task1(f));
    }

    @Test
    fun testSafe1_1() {
        var seq = Sequence()
        seq.numbers = ArrayList<Int>(listOf(7, 6, 4, 2, 1))
        assertTrue(dec2.isSafeSequence1(seq))
    }

    @Test
    fun testSafe1_2() {
        var seq = Sequence()
        seq.numbers = ArrayList<Int>(listOf(1, 2, 7, 8, 9))
        assertFalse(dec2.isSafeSequence1(seq))
    }

    @Test
    fun testSafe1_3() {
        var seq = Sequence()
        seq.numbers = ArrayList<Int>(listOf(9, 7, 6, 2, 1))
        assertFalse(dec2.isSafeSequence1(seq))
    }

    @Test
    fun testSafe1_4() {
        var seq = Sequence()
        seq.numbers = ArrayList<Int>(listOf(1, 3, 2, 4, 5))
        assertFalse(dec2.isSafeSequence1(seq))
    }

    @Test
    fun testSafe1_5() {
        var seq = Sequence()
        seq.numbers = ArrayList<Int>(listOf(8, 6, 4, 4, 1))
        assertFalse(dec2.isSafeSequence1(seq))
    }
    @Test
    fun testSafe1_6() {
        var seq = Sequence()
        seq.numbers = ArrayList<Int>(listOf(1, 3, 6, 7, 9))
        assertTrue(dec2.isSafeSequence1(seq))
    }
}