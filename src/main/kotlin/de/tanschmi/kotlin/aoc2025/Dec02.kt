package de.tanschmi.kotlin.aoc2025

class Dec02 {

    fun isValid(i: Long, isSillyPattern: (String) -> Boolean): Boolean {
        val s: String = "" + i
        if (startsWith0(s)) {
            return false
        }
        if (isSillyPattern(s)) {
            return false
        }

        return true
    }

    fun isSillyPattern1(s: String): Boolean {
        val length = s.length
        if (length % 2 != 0) {
            return false
        }
        val first = s.take(length / 2)
        val sec = s.substring(length / 2)

        return first == sec
    }

    fun isSillyPattern2(s: String): Boolean {
        val length = s.length
        for (i in 1..length / 2) {
            if (length % i == 0) {
                val part = s.take(i)
                val repeated = part.repeat(length / i)
                if (repeated == s && length / i >= 2) {
                    return true
                }
            }
        }
        if (length % 2 != 0) {
            return false
        }
        val first = s.take(length / 2)
        val sec = s.substring(length / 2)

        return first == sec
    }

    fun startsWith0(s: String): Boolean {
        return s.startsWith("0")
    }

    fun step1(line: String): Long {
        val validIds: ArrayList<Long> = ArrayList()
        val invalidIds: ArrayList<Long> = ArrayList()
        val idRanges: List<String> = line.split(",")
        for (idRange in idRanges) {

            val nos: List<String> = idRange.split("-")
            val from = nos[0].toLong()
            val to = nos[1].toLong()

            analyseRange(from, to, invalidIds, validIds, ::isSillyPattern1)

        }

        return invalidIds.sum()
    }

    fun step2(line: String): Long {
        val validIds: ArrayList<Long> = ArrayList()
        val invalidIds: ArrayList<Long> = ArrayList()
        val idRanges: List<String> = line.split(",")
        for (idRange in idRanges) {

            val nos: List<String> = idRange.split("-")
            val from = nos[0].toLong()
            val to = nos[1].toLong()

            analyseRange(from, to, invalidIds, validIds, ::isSillyPattern2)

        }

        return invalidIds.sum()
    }

    fun analyseRange(
        from: Long,
        to: Long,
        invalidIds: ArrayList<Long>,
        validIds: ArrayList<Long>,
        isSillyPattern: (String) -> Boolean
    ) {

        for (i in from..to) {
            if (isValid(i, isSillyPattern)) {
                validIds.add(i)
            } else {
                invalidIds.add(i)
            }
        }

    }
}