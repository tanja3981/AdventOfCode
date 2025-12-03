package de.tanschmi.kotlin.aoc2025.dec03

class Dec03 {

    fun step1(lines: List<String>): Long {
        var result = 0L
        for (line in lines) {
            result += findInLine(line)
        }
        return result
    }

    fun findInLine(line: String): Long {

        val list = line.indices.flatMap { i ->
            ((i + 1) until line.length).map { j ->
                "${line[i]}${line[j]}"
            }
        }
       val result = list.maxOf { it.toLong() }

        return result
    }
}