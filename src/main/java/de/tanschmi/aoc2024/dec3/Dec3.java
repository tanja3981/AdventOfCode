package de.tanschmi.aoc2024.dec3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static de.tanschmi.aoc2024.NumberUtil.parseToInt;

@Slf4j
public class Dec3 {
    final String regex = "mul\\(\\d{1,3},\\d{1,3}\\)";
    final Pattern mulPattern = Pattern.compile(regex);

    public int task1(File input) throws IOException {

        List<String> lines = FileUtils.readLines(input, Charset.defaultCharset());
        int sum = 0;
        for (String line : lines) {
            sum += parseString(line);


        }
        log.info("Gesamtsumme: {}", sum);
        return sum;
    }

    int parseString(String text) {
        Matcher m = mulPattern.matcher(text);
        return m.results()
                .peek(matchResult -> {
                    log.info(matchResult.group());
                })
                .mapToInt(matchResult -> {
                    return multiply(matchResult);
                })
                .sum()
        ;
    }

    int multiply(MatchResult matchResult) {
        String match = matchResult.group();
        int comma = match.indexOf(",");
        String first = match.substring(4, comma);
        String second = match.substring(comma + 1, match.length() - 1);
        int m = parseToInt(first) * parseToInt(second);
        log.info("{} * {} = {}", first, second, m);
        return m;
    }
}
