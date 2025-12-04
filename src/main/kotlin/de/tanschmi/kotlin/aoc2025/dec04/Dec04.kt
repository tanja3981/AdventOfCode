package de.tanschmi.kotlin.aoc2025.dec04

class Dec04 {

    fun step1(input: String): Int {

        val lines = input.lines()
        val matrix: MutableList<MutableList<Char>> = ArrayList()
        for (line in lines) {
            matrix.add(ArrayList(line.toList()))
        }

        return countRemovableRolls(matrix)
    }

    fun step2(input: String): Int {

        val lines = input.lines()
        val matrix: MutableList<MutableList<Char>> = ArrayList()
        for (line in lines) {
            matrix.add(ArrayList(line.toList()))
        }

        var clone = deepcloneMatrix(matrix)
        var removed = 0
        var removable: Int
        do {
            removable = countRemovableRolls(clone)
            removed += removable
            clone = deepcloneMatrix(clone)
        } while (removable > 0)
        return removed
    }

    fun deepcloneMatrix(matrix: MutableList<MutableList<Char>>): MutableList<MutableList<Char>> {
        return matrix.map { it.toMutableList() }.toMutableList()
    }

    /**
     * for debugging
     */
    fun toString(matrix: MutableList<MutableList<Char>>) : String {
        var out = ""
        for(row in 0..<matrix.size) {
            out += System.lineSeparator()
            for(col in 0..<matrix[row].size) {
                out += matrix[row][col]
            }
        }
        return out
    }

    fun countRemovableRolls(clone: MutableList<MutableList<Char>>): Int {
        val matrix = deepcloneMatrix(clone) //kopien um unveränderte daten zu LESEN
        var countAccessable = 0
        for (rowIndex in 0..<matrix.size) {
            //println()
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
                            if (dr == rowIndex && dc == colIndex) { //sich selbst auslassen
                                continue
                            }
                            if (matrix[dr][dc] == '@') {
                                countNachbarrollen++
                            }
                        }
                    }
                    if (countNachbarrollen < 4) {
                        countAccessable++
                        clone[rowIndex][colIndex] = 'x'
                        //print('X')
                    } else {
                        //print('@')
                        //clone[rowIndex][colIndex] = '?'
                    }
                } else if (char == 'x') {
                    clone[rowIndex][colIndex] = '.'
                }
            }

        }

        return countAccessable
    }
}