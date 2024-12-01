package de.tanschmi.kotlin.aoc2024

import org.apache.commons.io.FileUtils
import org.apache.logging.log4j.kotlin.logger
import java.io.File
import java.nio.charset.Charset

class Dec1 {
    companion object {
        private val log = logger()
    }

    fun step1(input: File): Long {

        var lefts: ArrayList<Long> = ArrayList<Long>()
        var rights: ArrayList<Long> = ArrayList<Long>()

        readFile(input, lefts, rights)
        sortList(lefts, rights)
        var sum = calcDifference(lefts, rights)
        log.info("Summe: $sum")
        return sum
    }

    fun step2(input: File): Long {
        var lefts: ArrayList<Long> = ArrayList<Long>()
        var rights: ArrayList<Long> = ArrayList<Long>()

        readFile(input, lefts, rights)
        sortList(lefts, rights)
        var score = calcScore(lefts, rights)
        log.info("Score: $score")
        return score
    }

    fun calcScore(lefts: ArrayList<Long>, rights: ArrayList<Long>): Long {
        var sum: Long = 0
        for (l in lefts) {
            var score: Int = rights.filter { it == l }.count()
            sum += score * l
        }
        return sum
    }

    fun calcDifference(lefts: ArrayList<Long>, rights: ArrayList<Long>): Long {
        var sum: Long = 0
        for (i in 0 until lefts.size) {
            var l = lefts[i]
            var r = rights[i]
            if (l > r) {
                sum += l - r
            } else {
                sum += r - l
            }
        }
        return sum
    }

    fun sortList(lefts: ArrayList<Long>, rights: ArrayList<Long>) {
        lefts.sort()
        rights.sort()
        log.info("Left: $lefts")
        log.info("Right: $rights")
    }

    fun readFile(file: File, lefts: ArrayList<Long>, rights: ArrayList<Long>) {
        val lines: List<String> = FileUtils.readLines(file, Charset.defaultCharset())


        for (line in lines) {
            val splitted = line.split("   ")
            var left: String = splitted[0]
            var right: String = splitted[1]

            lefts.add(left.trim().toLong())
            rights.add(right.trim().toLong())
        }
    }

}