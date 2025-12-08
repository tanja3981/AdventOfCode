package de.tanschmi.kotlin.aoc2025

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Dec02Test {
    var s = Dec02()


    @Test
    fun isValid() {
        assertFalse(s.isValid(11, s::isSillyPattern1))
        assertTrue(s.isValid(12, s::isSillyPattern1))
        assertTrue(s.isValid(13, s::isSillyPattern1))
        assertTrue(s.isValid(14, s::isSillyPattern1))
        assertTrue(s.isValid(15, s::isSillyPattern1))
        assertFalse(s.isValid(22, s::isSillyPattern1))
    }

    @Test
    fun isSillyPattern1() {


        assertTrue(s.isSillyPattern1("55"))
        assertTrue(s.isSillyPattern1("6464"))
        assertTrue(s.isSillyPattern1("123123"))
        assertFalse(s.isSillyPattern1("1213"))
    }

    @Test
    fun startsWith0() {
        assertTrue(s.startsWith0("0101"))
        assertFalse(s.startsWith0("101"))
    }

    @Test
    fun analyseRange11_22() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(11, 22, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(11L, 22L), invalidIds)
    }

    @Test
    fun analyseRange95_115() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(95, 115, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(99L), invalidIds)
    }

    @Test
    fun analyseRange998_1012() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(998, 1012, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(1010L), invalidIds)
    }

    @Test
    fun analyseRange1188511880_1188511890() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(1188511880, 1188511890, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(1188511885L), invalidIds)
    }

    @Test
    fun analyseRange222220_222224() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(222220, 222224, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(222222L), invalidIds)
    }

    @Test
    fun analyseRange1698522_1698528() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(1698522, 1698528, invalidIds, validIds, s::isSillyPattern1)
        assertTrue(invalidIds.isEmpty())
    }

    @Test
    fun analyseRange446443_446449() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(446443, 446449, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(446446L), invalidIds)
    }

    @Test
    fun analyseRange38593856_38593862() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(38593856, 38593862, invalidIds, validIds, s::isSillyPattern1)
        assertEquals(arrayListOf(38593859L), invalidIds)
    }


    @Test
    fun step1_exampleValue() {
        val input = """
            11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
        """.trimIndent()

        val result = s.step1(input)
        assertEquals(1227775554, result)
    }

    @Test
    fun step1() {
        val input = """
    269194394-269335492,62371645-62509655,958929250-958994165,1336-3155,723925-849457,4416182-4470506,1775759815-1775887457,44422705-44477011,7612653647-7612728309,235784-396818,751-1236,20-36,4-14,9971242-10046246,8796089-8943190,34266-99164,2931385381-2931511480,277-640,894249-1083306,648255-713763,19167863-19202443,62-92,534463-598755,93-196,2276873-2559254,123712-212673,31261442-31408224,421375-503954,8383763979-8383947043,17194-32288,941928989-941964298,3416-9716
""".trimIndent()
        val result = s.step1(input)
        assertEquals(31210613313, result)

    }

    @Test
    fun isSillyPattern2() {
        assertTrue(s.isSillyPattern1("12341234"))
        assertTrue(s.isSillyPattern2("123123123"))
        assertTrue(s.isSillyPattern2("1212121212"))
        assertTrue(s.isSillyPattern2("1111111"))
    }

    @Test
    fun analyseRange2_11_22() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(11, 22, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(11L, 22L), invalidIds)
    }

    @Test
    fun analyseRange2_95_115() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(95, 115, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(99L, 111L), invalidIds)
    }

    @Test
    fun analyseRange2_998_1012() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(998, 1012, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(999L, 1010L), invalidIds)
    }

    @Test
    fun analyseRange2_1188511880_1188511890() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(1188511880, 1188511890, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(1188511885L), invalidIds)
    }

    @Test
    fun analyseRange2_222220_222224() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(222220, 222224, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(222222L), invalidIds)
    }

    @Test
    fun analyseRange2_1698522_1698528() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(1698522, 1698528, invalidIds, validIds, s::isSillyPattern2)
        assertTrue(invalidIds.isEmpty())
    }

    @Test
    fun analyseRange2_446443_446449() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(446443, 446449, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(446446L), invalidIds)
    }

    @Test
    fun analyseRange2_38593856_38593862() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(38593856, 38593862, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(38593859L), invalidIds)
    }

    @Test
    fun analyseRange2_565653_565659() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(565653, 565659, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(565656L), invalidIds)
    }

    @Test
    fun analyseRange2_824824821_824824827() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(824824821, 824824827, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(824824824L), invalidIds)
    }

    @Test
    fun analyseRange2_2121212118_2121212124() {
        val invalidIds = ArrayList<Long>()
        val validIds = ArrayList<Long>()

        s.analyseRange(2121212118, 2121212124, invalidIds, validIds, s::isSillyPattern2)
        assertEquals(arrayListOf(2121212121L), invalidIds)
    }


    @Test
    fun step2_exampleValue() {
        val input = """
            11-22,95-115,998-1012,1188511880-1188511890,222220-222224,1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124
        """.trimIndent()

        val result = s.step2(input)
        assertEquals(4174379265L, result)
    }

    @Test
    fun step2() {
        val input = """
    269194394-269335492,62371645-62509655,958929250-958994165,1336-3155,723925-849457,4416182-4470506,1775759815-1775887457,44422705-44477011,7612653647-7612728309,235784-396818,751-1236,20-36,4-14,9971242-10046246,8796089-8943190,34266-99164,2931385381-2931511480,277-640,894249-1083306,648255-713763,19167863-19202443,62-92,534463-598755,93-196,2276873-2559254,123712-212673,31261442-31408224,421375-503954,8383763979-8383947043,17194-32288,941928989-941964298,3416-9716
""".trimIndent()
        val result = s.step2(input)
        assertEquals(41823587546L, result)

    }
}