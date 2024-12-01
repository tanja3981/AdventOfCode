package de.tanschmi.aoc2024.dec1;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class Dec1 {

    public long step1(File input) throws IOException {
        ArrayList<Long> lefts = new ArrayList<>();
        ArrayList<Long> rights = new ArrayList<>();

        new ListReader().read(input, lefts, rights);

        sortColumns(lefts, rights);

        if (lefts.size() != rights.size()) {
            throw new RuntimeException("Die Länge der Liste ist unterschiedlich!!!");
        }

        long summe = calcDiffs(lefts, rights);
        log.info("Summe: {}", summe);
        return summe;
    }

    public long step2(File input) throws IOException {
        ArrayList<Long> lefts = new ArrayList<>();
        ArrayList<Long> rights = new ArrayList<>();

        new ListReader().read(input, lefts, rights);

        long sum = findSimilarities(lefts, rights);

        log.info("Summe {}", sum);
        return sum;
    }

    Long calcDiffs(ArrayList<Long> lefts, ArrayList<Long> rights) {
        long sum = 0;

        for (int i = 0; i < lefts.size(); i++) {
            long left = lefts.get(i);
            long right = rights.get(i);
            long diff;
            if (left > right) {
                diff = left - right;
            } else {
                diff = right - left;
            }
            sum += diff;
        }
        return sum;
    }

    Long findSimilarities(ArrayList<Long> lefts, ArrayList<Long> rights) {
        long scores = 0;
        for (long left : lefts) {
            long occur = rights.stream()
                    .filter(right -> right == left)
                    .count();
            long score = occur * left;
            scores += score;
        }
        return scores;
    }

    void sortColumns(ArrayList<Long> lefts, ArrayList<Long> rights) {
        sortList(lefts);
        sortList(rights);

        log.debug(lefts.toString());
        log.debug(rights.toString());
    }

    void sortList(ArrayList<Long> lefts) {

        lefts.sort(Long::compareTo);
    }
}
