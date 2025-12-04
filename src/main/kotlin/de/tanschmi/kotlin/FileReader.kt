package de.tanschmi.kotlin

import org.apache.commons.io.FileUtils
import org.apache.logging.log4j.kotlin.logger
import java.io.File
import java.nio.charset.Charset

class FileReader {
    companion object {
        private val log = logger()
    }

    fun readLines(file: File): List<String> {
        var lines: List<String> = FileUtils.readLines(file, Charset.defaultCharset())
        return lines;
    }
}