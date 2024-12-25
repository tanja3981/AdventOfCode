package de.tanschmi.kotlin.aoc2024


fun deepClone(matrix: Array<CharArray>): Array<CharArray> {
    return Array(matrix.size) { rowIndex ->
        matrix[rowIndex].copyOf() // Kopiert jedes CharArray
    }
}