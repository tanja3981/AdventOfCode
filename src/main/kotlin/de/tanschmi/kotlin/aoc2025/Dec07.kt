package de.tanschmi.kotlin.aoc2025

class Dec07 {
    val SPLITTER = '^'

    fun step1(input: String): Long {

        val matrix = input.lines().map { it.toCharArray() }
        val start = matrix.first().indexOf('S')
        var currentLocs: Collection<Int> = listOf(start)
        var splits = 0L
        matrix.forEach { line ->
            val nextCoords = HashSet<Int>()

            currentLocs.forEach { loc ->
                if (line[loc] == SPLITTER) {
                    splits++
                    nextCoords.add(loc - 1)
                    nextCoords.add(loc + 1)
                } else {
                    nextCoords.add(loc)
                }
            }
            currentLocs = nextCoords
        }
        return splits
    }

    fun step2(input: String): Long {
        val matrix = input.lines().map { it.toCharArray() }

        val startX = matrix.first().indexOf('S')
        var currentLocs = mapOf(startX to 1L)  //map mit default value initialisieren

        matrix.forEach { line ->
            val nextCoords = mutableMapOf<Int, Long>()

            currentLocs.forEach { loc ->
                if (line[loc.key] == SPLITTER) {
                    nextCoords[loc.key - 1] = loc.value + nextCoords.getOrDefault(loc.key - 1, 0L)
                    nextCoords[loc.key + 1] = loc.value + nextCoords.getOrDefault(loc.key + 1, 0L)
                } else {
                    nextCoords[loc.key] = loc.value + nextCoords.getOrDefault(loc.key, 0L)
                }
            }
            currentLocs = nextCoords
        }
        return currentLocs.values.sum()
    }
}