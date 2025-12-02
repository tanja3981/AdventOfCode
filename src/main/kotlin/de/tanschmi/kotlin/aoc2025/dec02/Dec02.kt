package de.tanschmi.kotlin.aoc2025.dec02

class Dec02 {

    fun isValid(i: Long): Boolean {
        val s: String = "" + i
        if (startsWith0(s)) {
            return false
        }
        if (isSillyPattern(s)) {
            return false
        }

        return true
    }

    fun isSillyPattern(s: String): Boolean {
        val length = s.length
        if (length % 2 != 0) {
            return false
        }
        val first = s.take(length / 2)
        val sec = s.substring(length / 2)

        return first == sec
    }

    fun startsWith0(s: String): Boolean {
        if (s.startsWith("0")) {
            return true
        }
        return false
    }

    fun step1(line: String): Long {
        val validIds: ArrayList<Long> = ArrayList()
        val invalidIds: ArrayList<Long> = ArrayList()
        val idRanges: List<String> = line.split(",")
        for (idRange in idRanges) {

            val nos: List<String> = idRange.split("-")
            var from = nos.get(0).toLong()
            var to = nos.get(1).toLong()

            analyseRange(from, to, invalidIds, validIds)

        }

        return invalidIds.sum()
    }

    fun analyseRange(from: Long, to: Long, invalidIds: ArrayList<Long>, validIds: ArrayList<Long>) {

        for (i in from..to) {
            if (isValid(i)) {
                validIds.add(i)
            } else {
                invalidIds.add(i)
            }
        }

    }
}
