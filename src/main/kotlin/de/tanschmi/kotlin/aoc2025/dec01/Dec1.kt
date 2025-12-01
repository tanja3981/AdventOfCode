package de.tanschmi.kotlin.aoc2025.dec01

import org.apache.logging.log4j.kotlin.logger

class Dec1 {
    companion object {
        private val log = logger()
    }

    fun parseLine(line: String): Int? {
        val regex = Regex("([LR])(\\d+)")
        val match = regex.matchEntire(line.trim())
        return match?.let {
            val direction: Char = it.groupValues[1][0]   // 'L' oder 'R'
            val number: Int = it.groupValues[2].toInt() // die Zahl
            when (direction) {
                'L' -> return (-1 * number)
                'R' -> return number
                else -> {
                    log.error("Not parsable: $line"); return 0
                }
            }
        }
    }

    fun step1(input: List<String>): Long {
        var counter: Long = 0;
        var start: Int = 50;
        log.info("Starting at $start")
        for (line in input) {
            var toDial: Int? = Dec1().parseLine(line)
            if (toDial != null) {
                start = dial1(toDial, start);
            }
            if (start == 0) {
                counter++;
            }
        }
        return counter
    }


    fun dial1(right: Int, start: Int = 50): Int {
        log.info("Dialing (1) $right from $start")
        var newDial: Int = (start + right) % 100;
        return newDial;
    }


    fun step2(input: List<String>): Long {
        var counter: Long = 0;
        var start: Int = 50;
        for (line in input) {
            log.debug("handling $line")
            var toDial: Int? = parseLine(line)
            if (toDial != null) {
                var result: Pair<Long, Int> = dial2(toDial, start)

                counter += result.first
                start = result.second
            }

        }
        return counter
    }

    /**
     * brute force Methode, gibt sicher was schöneres, aber reicht erst mal
     */
    fun dial2(rightParam: Int, startParam: Int = 50): Pair<Long, Int> {
        log.debug("Dialing (2) $rightParam from $startParam")

        var zeros = 0L
        var start = startParam
        var right = rightParam

        while(right > 0) {
            start++
            start %= 100;
            right--;
            if(start == 0)
                zeros++
        }
        while(right < 0) {
            start--
            if(start < 0)
                start += 100
            right++
            if(start == 0)
                zeros++
        }

        log.info("Clicked $zeros at 0, new dial is $start")
        return Pair(zeros, start)
    }
}