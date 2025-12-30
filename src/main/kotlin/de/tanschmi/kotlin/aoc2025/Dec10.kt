package de.tanschmi.kotlin.aoc2025

class Dec10 {

    data class Step(val prevState: Long, val button: Long?)
    data class Game(val initial: Long, val buttons: List<Long>, val target: Long)

    fun parseLine(line: String): Game {

        var parts = line.split("]")
        val start = parts[0].trim('[').replace('.', '0').replace('#', '1').trim()

        parts = parts[1].split("{")

        val wiring: String = parts[1].trim('}').trim()
        val buttonPart: String = parts[0]

        val buttons: List<String> = parseButtons(buttonPart, start.length)
        val target = "0".repeat(start.length)

        return Game(start.toBitMask(), buttons.map { it -> it.toBitMask() }, target.toBitMask())
    }

    fun step1(input: String): Long {

        var result: Long = 0L
        for (line in input.lines()) {

            val game = parseLine(line)
            val lineResult: Long = getFastestSequence(game)

            //println("$line: $lineResult")

            result += lineResult
        }
        return result
    }

    private fun getFastestSequence(game: Game): Long {

        val startMask: Long = game.initial
        val targetMask: Long = game.target
        val buttonMasks: List<Long> = game.buttons

        val queue = ArrayDeque(listOf(startMask))
        val results = HashMap<Long, List<Long>>()
        results.put(startMask, ArrayList<Long>())

        while (queue.isNotEmpty()) {
            val curr = queue.removeFirst()

            if (curr == targetMask) {
                break
            }
            for (button in buttonMasks) {
                val next = curr xor button

                if(results.contains(next)) {
                    //been there - done that...
                    continue
                }

                //bisherige buttons bis hierhin
                val currList: List<Long> = results.getOrDefault(curr, ArrayList<Long>())
                val nextList = ArrayList<Long>(currList)
                nextList.add(button)
                results[next] = nextList
                if (next != targetMask) {
                    queue.add(next)
                }
            }

            if (results.contains(targetMask)) {
                val buttonsPressed = results.getOrDefault(targetMask, ArrayList<Long>())
                return buttonsPressed.size.toLong()
            }
        }

        println("results: $results")
        return 0L
    }

    fun parseButtons(buttonPart: String, size: Int): kotlin.collections.List<String> {
        return Regex("""\(([^)]*)\)""")
            .findAll(buttonPart)
            .map { matchResult ->
                matchResult.groupValues[1]
                    .split(",")
                    .map { it.toInt() }
            }
            .map { list ->
                var bitmask = ""
                for (i in 0..<size) {
                    if (list.contains(i)) {
                        bitmask += "1"
                    } else {
                        bitmask += "0"
                    }
                }
                bitmask
            }
            .toList()
    }

    fun String.toBitMask(): Long {
        require(all { it == '0' || it == '1' }) { "Nur '0' und '1' erlaubt: \"$this\"" }
        var mask = 0L
        for (c in this) {
            mask = (mask shl 1) or (c - '0').toLong()
        }
        return mask
    }


}