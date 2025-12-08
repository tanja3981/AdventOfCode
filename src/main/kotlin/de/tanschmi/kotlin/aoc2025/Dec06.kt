package de.tanschmi.kotlin.aoc2025

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

            var subresult = matrix[0][i].toLong()
            for (j in 1..<matrix.size - 1) {
                val line = matrix[j]
                subresult = operation(op, subresult, line[i].toLong())
            }
            results.add(subresult)
        }
        return results.sum()
    }

    fun step2(input: String): Long {
        val lines = ArrayList<String>(input.lines())
        val last = lines.removeLast()

        val regex = Regex("[+\\-*/]\\s+")
        var blocks = regex.findAll(last).map { matchResult ->
            val token = matchResult.value
            val start = matchResult.range.first   // Startindex im Originalstring
            val length = matchResult.range.last - matchResult.range.first     // Endindex im Originalstring
            Operator(token, start, length)
        }.toList()

        //rechts nach links
        blocks = blocks.reversed()
        val results = ArrayList<Long>()
        var firstBlock = true
        for (block in blocks) {
            val operator = block.operator
            val start = block.start
            var length = block.length
            if (firstBlock) {
                firstBlock = false //der letzte Block hat kein Leerzeichen mehr am Ende
            } else {
                length -= 1 //das Leerzeichen für die Block Trennung
            }
            val numbers = ArrayList<Long>()

            for (lastIndex in (start + length) downTo start) {
                var number = ""
                for (line in lines) {
                    number += line.toCharArray()[lastIndex]
                }
                numbers.add(number.trim().toLong())
            }

            var zresult = numbers.first()
            for (z in 1..<numbers.size) {
                zresult = operation(operator, zresult, numbers[z])
            }
            results.add(zresult)

        }
        return results.sum()
    }

    fun operation(operation: String, value1: Long, value2: Long): Long =
        when (operation.trim()) {
            "+" -> value1 + value2
            "-" -> value1 - value2
            "*" -> value1 * value2
            "/" -> value1 / value2
            else -> throw Error("Komische Operation $operation")
        }

    data class Operator(val operator: String, val start: Int, val length: Int)

}

