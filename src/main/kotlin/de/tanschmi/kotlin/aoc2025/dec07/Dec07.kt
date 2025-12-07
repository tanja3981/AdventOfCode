package de.tanschmi.kotlin.aoc2025.dec07

class Dec07 {
    val SPLITTER = '^'
    var splitCounter: Long = 0L
    fun step1(input: String): Long {
        splitCounter = 0

        val matrix = input.lines().map { it.toCharArray() }

        val start = findStart(matrix)
        require(start != null) { "S wurde nicht gefunden!" }
        tachyonBeam(matrix, arrayListOf(start))
        return splitCounter
    }

    fun tachyonBeam(matrix: List<CharArray>, coords: Collection<Coord>) {
        val newCoords = HashSet<Coord>()

        for (start in coords) {
            val newY = start.y + 1
            if(newY >= matrix.size)
                continue
            val x = start.x
            if (matrix[newY][x] == SPLITTER) {
                //split
                if (x - 1 >= 0) { //left
                    newCoords.add(Coord(x - 1, newY))
                }
                if (x + 1 < matrix[newY].size) { //right
                    newCoords.add(Coord(x + 1, newY))
                }
                splitCounter++
            } else {
                newCoords.add(Coord(x, newY))
            }
        }

        if (newCoords.isNotEmpty()) {
            tachyonBeam(matrix, newCoords)
        }
    }

    fun findStart(input: List<CharArray>): Coord? {
        for (y in 0..<input.size) {
            val line = input[y]
            for (x in 0..<line.size) {
                if (input[y][x] == 'S')
                    return Coord(x, y)
            }
        }
        return null
    }
}

data class Coord(
    val x: Int,
    val y: Int
)