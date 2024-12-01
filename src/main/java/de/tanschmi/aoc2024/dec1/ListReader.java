package de.tanschmi.aoc2024.dec1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListReader {

    public void read(File inputFile, ArrayList<Long> lefts, ArrayList<Long> rights) throws IOException {

        List<String> lines = FileUtils.readLines(inputFile, Charset.defaultCharset());
        for(String line : lines) {
            String[] s = line.split("  ");

            long left = parseToLong(s[0]);
            long right = parseToLong(s[1]);

            lefts.add(left);
            rights.add(right);
        }


    }

    long parseToLong(String s) {
        try {
            return Long.parseLong(s.trim());
        } catch (NumberFormatException e) {
            log.error("Fehler bei Wert {}", s);
            throw e;
        }
    }
}
