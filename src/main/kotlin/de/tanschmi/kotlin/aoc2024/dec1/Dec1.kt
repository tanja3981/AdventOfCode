package de.tanschmi.kotlin.aoc2024.dec1

import de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.FileReader
import org.apache.logging.log4j.kotlin.logger
import java.io.File

class Dec1 {
    companion object {
        private val log = logger()
    }

    fun step1(input: File): Long {

        var lefts: ArrayList<Long> = ArrayList<Long>()
        var rights: ArrayList<Long> = ArrayList<Long>()

        FileReader().readFile(input, lefts, rights)
        sortList(lefts, rights)
        var sum = calcDifference(lefts, rights)
        log.info("Summe: $sum")
        return sum
    }

    fun step2(input: File): Long {
        var lefts: ArrayList<Long> = ArrayList<Long>()
        var rights: ArrayList<Long> = ArrayList<Long>()

        FileReader().readFile(input, lefts, rights)
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



}