package de.tanschmi.kotlin.aoc2024

import org.apache.commons.io.FileUtils
import org.apache.logging.log4j.kotlin.logger
import java.io.File
import java.nio.charset.Charset

class FileReader {
    companion object {
        private val log = logger()
    }

    fun readFile(file: File, lefts: ArrayList<Long>, rights: ArrayList<Long>) {
        val lines: List<String> = FileUtils.readLines(file, Charset.defaultCharset())


        for (line in lines) {
            val splitted = line.split("   ")
            var left: String = splitted[0]
            var right: String = splitted[1]

            lefts.add(left.trim().toLong())
            rights.add(right.trim().toLong())
        }
    }
}