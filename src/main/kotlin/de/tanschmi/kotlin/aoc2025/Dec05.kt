package de.tanschmi.kotlin.aoc2025

class Dec05 {

    fun step1(lines: List<String>): Int {

        val freshs = HashSet<String>()
        val avails = HashSet<Long>()

        var beforeEmptyLine = true

        for (line in lines) {
            if (line.trim().isEmpty()) {
                require(beforeEmptyLine) { "We have two empty lines!" }
                beforeEmptyLine = false
                continue
            }
            if (beforeEmptyLine) {
                freshs.add(line.trim())
            } else {
                avails.add(line.trim().toLong())
            }
        }
        var countFresh = 0
        for (avail in avails) {
            countFresh += parseAvails(avail, freshs)
        }
        return countFresh
    }

    fun parseAvails(avail: Long, freshs: Set<String>): Int {
        for (fresh in freshs) {
            val parts = fresh.split("-")
            require(parts.size == 2) { "Expected range!" }
            val from = parts[0].trim().toLong()
            val to = parts[1].trim().toLong()

            if (from <= avail && avail <= to) {
                return 1
            }
        }
        return 0
    }

    fun step2(lines: List<String>): Long {

        val freshRanges = ArrayList<Range>()
        for (line in lines) {
            if (line.trim().isEmpty()) {
                break
            }
            val parts = line.split("-")
            require(parts.size == 2) { "Expected range!" }
            val from = parts[0].trim().toLong()
            val to = parts[1].trim().toLong()
            freshRanges.add(Range(from, to))
        }

        return countMerged(freshRanges)

    }

    fun countMerged(unsorted: List<Range>): Long {
        val sorted = unsorted.sortedBy { it.start }
        var currentStart = sorted.first().start
        var currentEnd = sorted.first().end
        var total: Long = 0

        for (range in sorted.drop(1)) {
            if (range.start <= currentEnd + 1) { //range erweitern
                currentEnd = maxOf(currentEnd, range.end)
            } else {
                total += (currentEnd - currentStart + 1)
                currentStart = range.start
                currentEnd = range.end

            }
        }
        total += (currentEnd - currentStart + 1)
        return total
    }


    data class Range(
        val start: Long,
        val end: Long
    )
}
