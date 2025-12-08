package de.tanschmi.kotlin.aoc2025

@Deprecated("Dieser Code ist viel zu langsam, Laufzeit unbekannt. Verwende Dec02Alternate2 mit besserem Algorithmus!")
class Dec03Alternate1 {

    fun step1(lines: List<String>): Long {
        var result = 0L
        for (line in lines) {
            result += findInLine(line)
        }
        return result
    }

    fun step2(lines: List<String>): Long {
        var result = 0L
        for (line in lines) {
            result += findInLine(line, 12)
        }
        return result
    }

    fun findInLine(line: String, n: Int = 2): Long {
        val list = allCombinations(line.toList(), n)
        val result = list
            .map { it.joinToString("") }
            .maxOf { it.toLong() }

        return result
    }

    fun allCombinations(line: List<Char>, n: Int): Sequence<List<Char>> = sequence {
        if (n == 0) {
            yield(emptyList())
        } else {
            line.forEachIndexed { i, char ->
                allCombinations(line.drop(i + 1), n - 1)
                    .forEach { rest ->
                        yield(listOf(char) + rest)
                    }
            }
        }
    }

}