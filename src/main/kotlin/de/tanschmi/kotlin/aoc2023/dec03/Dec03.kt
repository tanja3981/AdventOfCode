package de.tanschmi.kotlin.aoc2023.dec03


class Dec03 {
   fun step1(input: String): Long {
        val regex = Regex("\\d+")
        val lines = input.lines()
        val rowCount = lines.size
        val result = mutableListOf<Long>()

        for (row in 0 until rowCount) {
            val line = lines[row]
            val colCount = line.length
            regex.findAll(line).forEach { match ->
                val start = match.range.start
                val end = match.range.last
                val number = match.value
                if (checkAdjacant(start, end, row, rowCount, colCount, lines)) {
                    result.add(number.toLong())
                }
            }
        }
        return result.sum()

    }

    fun checkAdjacant(
        start: Int, end: Int, row: Int, rowCount: Int,
        colCount: Int, lines: List<String>
    ): Boolean {
        var adjacant = false
        for (buchstabe in start..end) {
            for (drow in -1..1) {
                for (dcol in -1..1) {
                    if (drow == 0 && dcol == 0) //eigene zelle überspringen
                        continue
                    val nachbarrow = row + drow
                    val nachbarcol = buchstabe + dcol

                    if (nachbarrow in 0 until rowCount //Ränder nach oben/unten beachten
                        && nachbarcol in 0 until colCount //Ränder nach links/rechts
                    ) {
                        val ch = lines[nachbarrow][nachbarcol]
                        if (!ch.isDigit() && ch != '.') {
                            adjacant = true
                        }
                    }

                }
            }
        }
        return adjacant
    }
}