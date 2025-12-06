package de.tanschmi.kotlin.aoc2025.dec06

import java.util.regex.Matcher
import kotlin.math.max

class Dec06 {

    fun parseInput1(input: String): List<List<String>> {
        return input.lines()
            .filter { it.isNotBlank() }
            .map { it.trim().split("\\s+".toRegex()) }
    }

    fun step1(input: String): Long {
        val matrix = parseInput1(input)

        val operations = matrix.last()
        val results = ArrayList<Long>()
        for (i in 0..<operations.size) {
            val op = operations[i]

            var maxDigits = 0
            for(j in 0..matrix.size -1) {
               maxDigits = max(maxDigits, matrix[j][i].length)
            }
            println("$i: $maxDigits")

            var subresult = matrix[0][i].toLong()
            for (j in 1..<matrix.size -1) {
                val line = matrix[j]
                val value = line[i].padStart(maxDigits, '0')
                subresult = operation(op, subresult, value.toLong())
            }
            results.add(subresult)
        }
        return results.sum()
    }

    fun operation(operation: String, value1: Long, value2: Long): Long =
        when (operation) {
            "+" -> value1 + value2
            "-" -> value1 - value2
            "*" -> value1 * value2
            "/" -> value1 / value2
            else -> throw Error("Komische Operation " + operation)
        }

    fun step2(input: String): Long {
        val matrix = parseInput2(input)

        val operations = matrix.removeLast()
        val results = ArrayList<Long>()
        for (i in 0..<operations.size) {
            val op = operations[i]
            var subresult = matrix[0][i].toLong()

            for (j in 1..<matrix.size) {
                val line = matrix[j]
                subresult = operation(op, subresult, line[i].toLong())
            }
            results.add(subresult)
        }
        return results.sum()
    }

    fun parseInput2(input: String): ArrayList<ArrayList<String>> {

        val matrix = ArrayList<ArrayList<String>>()
        for (line in input.lines()) {
            if (line.isEmpty())
                continue
            val parts = line.trim().split("\\s+".toRegex())
            val sublist = ArrayList<String>()
            for (part in parts) {
                sublist.add(part.trim())
            }
            matrix.add(sublist)
        }
        return matrix
    }
}