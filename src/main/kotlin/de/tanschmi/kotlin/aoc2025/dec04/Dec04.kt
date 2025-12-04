package de.tanschmi.kotlin.aoc2025.dec04

class Dec04 {

    fun step1(input: String): Long {

        val lines = input.lines()
        val matrix: MutableList<List<Char>> = ArrayList<List<Char>>()
        for (line in lines) {
            matrix.add(line.toList())
        }

        var countAccessable = 0L
        for (rowIndex in 0..<matrix.size) {
            println()
            val row: List<Char> = matrix[rowIndex]
            for (colIndex in 0..<row.size) {
                val char = row[colIndex]
                if (char == '@') { //prüfe nur Rollen
                    var countNachbarrollen = 0
                    for (dr in (rowIndex - 1)..(rowIndex + 1)) {
                        for (dc in (colIndex - 1)..(colIndex + 1)) {
                            if (dr < 0 || dr >= matrix.size
                                || dc < 0 || dc >= matrix[dr].size
                            ) {
                                //wir sind außerhalb des Grid, weitermachen
                                continue
                            }
                            if(dr == rowIndex && dc == colIndex) { //sich selbst auslassen                            {
                                continue
                            }
                            if (matrix[dr][dc] == '@') {
                                countNachbarrollen++
                            }
                        }
                    }
                    if(countNachbarrollen < 4) {
                        countAccessable++
                        print('X')
                    } else {
                        print('@')
                    }
                } else {
                    print(char)
                }
            }
        }
        return countAccessable
    }
}