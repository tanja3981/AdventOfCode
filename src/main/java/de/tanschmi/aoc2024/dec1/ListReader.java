package de.tanschmi.aoc2024.dec1;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ListReader {

    public void read(File inputFile, ArrayList<Integer> lefts, ArrayList<Integer> rights) throws IOException {


        List<String> lines = FileUtils.readLines(inputFile, Charset.defaultCharset());
        for(String line : lines) {
            String[] s = line.split("  ");

            int left = parseToInt(s[0].trim());
            int right = parseToInt(s[1].trim());

            lefts.add(left);
            rights.add(right);
        }


    }

    int parseToInt(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (NumberFormatException e) {
            log.error("Fehler bei Wert {}", s);
            throw e;
        }
    }
}
