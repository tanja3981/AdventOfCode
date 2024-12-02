package de.tanschmi.kotlin.aoc2024

import org.apache.logging.log4j.kotlin.logger
import java.io.File

const val LIMIT = 3;

class Dec2 {
    companion object {
        private val log = logger()
    }

    fun task1(input: File): Int {

        var sequences: ArrayList<Sequence> = FileReader().readSequences(input)
        var sum = countSafeSequences(sequences)
        log.info("Summe für Task 1: $sum")
        return sum
    }

    private fun countSafeSequences(sequences: ArrayList<Sequence>): Int {
        var sum: Int = 0
        for (sequence in sequences) {
            var isSafe: Boolean = isSafeSequence1(sequence)
            if (isSafe) {
                sum++;
            }
        }
        return sum;
    }


    fun isSafeSequence1(sequence: Sequence): Boolean {
        var increasing: Boolean? = null;
        for (i in 1..(sequence.numbers.size - 1)) {
            var first = sequence.numbers.get(i - 1)
            var secnd = sequence.numbers.get(i)
            if (first > secnd) {
                if (increasing == true) {
                    return false
                };
                if (increasing == null) {
                    increasing = false
                }
                if (first - secnd > LIMIT || first - secnd <= 0) {
                    return false;
                }
            } else {
                if (increasing == false) {
                    return false;
                }
                if (increasing == null) {
                    increasing = true
                }
                if (secnd - first > LIMIT || secnd - first <= 0) {
                    return false;
                }
            }
        }
        return true;
    }

}

class Sequence {
    var numbers: ArrayList<Int> = ArrayList<Int>();


}