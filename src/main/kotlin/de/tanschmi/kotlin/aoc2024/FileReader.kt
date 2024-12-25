package de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024

import de.tanschmi.kotlin.aoc2024.de.tanschmi.kotlin.aoc2024.dec2.Sequence
import org.apache.commons.io.FileUtils
import org.apache.logging.log4j.kotlin.logger
import java.io.File
import java.nio.charset.Charset

class FileReader {
    companion object {
        private val log = logger()
    }

    fun readFile(file: File, lefts: ArrayList<Long>, rights: ArrayList<Long>) {
        var lines: List<String> = FileUtils.readLines(file, Charset.defaultCharset())


        for (line in lines) {
            var splitted = line.split("   ")
            var left: String = splitted[0]
            var right: String = splitted[1]

            lefts.add(left.trim().toLong())
            rights.add(right.trim().toLong())
        }
    }

    fun readSequences(file: File): ArrayList<Sequence> {
        var lines: List<String> = FileUtils.readLines(file, Charset.defaultCharset())
        var sequences: ArrayList<Sequence> = ArrayList<Sequence>()

        for (line in lines) {
            var splitted = line.split(" ")
            var seq: Sequence = Sequence()
            for (s in splitted) {
                seq.numbers.add(s.toInt())
            }
            sequences.add(seq);
        }
        return sequences;
    }
}