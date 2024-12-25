package de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.dec2

import de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.FileReader
import org.apache.logging.log4j.kotlin.logger
import java.io.File

const val LIMIT = 3;

class Task1 {
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
            var isSafe: Boolean = isSafeSequence(sequence)
            if (isSafe) {
                sum++;
            }
        }
        return sum;
    }

    fun isSafeSequence(sequence: Sequence): Boolean {
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

class Task2 {
    companion object {
        private val log = logger()
    }

    fun task2(input: File): Int {

        var sequences: ArrayList<Sequence> = FileReader().readSequences(input)
        var sum = countSafeSequences(sequences)
        log.info("Summe für Task 2: $sum")
        return sum
    }

    private fun countSafeSequences(sequences: ArrayList<Sequence>): Int {
        var sum: Int = 0
        for (sequence in sequences) {
            var isSafe: Boolean = isSafeSequence(sequence)
            if (isSafe) {
                sum++;
            }
        }
        return sum;
    }

    fun isSafeSequence(sequence: Sequence): Boolean {
        var task1 = Task1()


        val subsequences = sequence.getSubsequences()
        for (s in subsequences) {
            if (task1.isSafeSequence(s)) {
                return true
            }
        }
return false;
        //return task1.isSafeSequence(sequence);
    }
}

class Sequence {
    var numbers: ArrayList<Int> = ArrayList<Int>();

    fun getSubsequences(): List<Sequence> {
        var list = ArrayList<Sequence>()
        for (i in 0..(numbers.size - 1)) {
            var newlist = ArrayList<Int>(numbers.filterIndexed { index, _ -> index != i })
            var newSeq = Sequence()
            newSeq.numbers = newlist
            list.add(newSeq)
        }
        return list
    }
}